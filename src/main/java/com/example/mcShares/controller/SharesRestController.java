package com.example.mcShares.controller;

import com.example.mcShares.adapter.SharesFileDetailsAdapter;
import com.example.mcShares.dto.CustomerSharesDetailsDTO;
import com.example.mcShares.model.Customer;
import com.example.mcShares.model.CustomerSharesDetails;
import com.example.mcShares.model.SharesFileUpload;
import com.example.mcShares.repository.ICustomerRepository;
import com.example.mcShares.repository.ICustomerSharesDetailsRepository;
import com.example.mcShares.repository.ISharesFileUploadRepository;
import com.example.mcShares.utils.CsvFileWriter;
import com.example.mcShares.utils.FormattingUtil;
import com.example.mcShares.validation.SharesFileValidator;
import com.example.mcShares.vo.DataItemCustomerVO;
import com.example.mcShares.vo.RequestDocVO;
import com.example.mcShares.vo.ResponseVO;
import com.example.mcShares.vo.SharesDetailsTypeVO;
import org.apache.cxf.common.util.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.ObjectUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import javax.ws.rs.BadRequestException;
import javax.ws.rs.NotFoundException;
import javax.ws.rs.core.Response;
import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Controller that expose all REST APIs for shares and customer details
 */
@RestController
@RequestMapping("/mcShares")
public class SharesRestController {

    private static final Logger LOGGER = LoggerFactory.getLogger(SharesRestController.class);
    @Resource
    private SharesFileDetailsAdapter sharesFileDetailsAdapter;
    @Autowired
    private ICustomerRepository customerRepository;
    @Autowired
    private ICustomerSharesDetailsRepository customerSharesDetailsRepository;
    @Autowired
    private ISharesFileUploadRepository sharesFileUploadRepository;
    @Resource
    private SharesFileValidator sharesFileValidator;
    @Resource
    private FormattingUtil formattingUtil;
    @Resource
    private CsvFileWriter csvFileWriter;

    /**
     * @param multipartFile
     * @return ResponseEntity
     * upload xml file
     * validation of xml is done
     * only valid records will be persisted
     */
    @PostMapping("/uploadAndValidateSharesFile/")
    @Transactional
    public ResponseEntity uploadAndValidateSharesFile(@RequestPart("file") MultipartFile multipartFile) {
        LOGGER.info("START uploadAndValidateSharesFile() ");
        ResponseVO responseVO = sharesFileValidator.validateSharesFile(multipartFile);

        if (ObjectUtils.isEmpty(responseVO)) {
            RequestDocVO requestDocVO = sharesFileValidator.unmarshallDocData(multipartFile);
            SharesFileUpload sharesFileUpload = new SharesFileUpload(multipartFile.getOriginalFilename(), requestDocVO.getDocRef(), formattingUtil.convertStringToDate(requestDocVO.getDocDate()), null);

            List<Customer> customers = new ArrayList<>();
            for (DataItemCustomerVO dataItemCustomerVO : requestDocVO.getDocData().getDataItemCustomerVO()) {
                Customer customer = sharesFileDetailsAdapter.fromVO(dataItemCustomerVO, sharesFileUpload);
                if (customer != null) {
                    customers.add(customer);
                }
            }

            responseVO = new ResponseVO(HttpStatus.OK.value(), sharesFileUpload.getStatus());
            sharesFileUploadRepository.save(sharesFileUpload);
            customerRepository.saveAll(customers);
        }

        LOGGER.info("END uploadAndValidateSharesFile()");
        return ResponseEntity.status(responseVO.getHttpCode()).body(responseVO);
    }

    /**
     * @param customerRef
     * @return List<Customer>
     * Can either retrieve all customers persisted or retrieve information of 1 customer via customerRef
     * To list all records as well as retrieve individual records
     */
    @GetMapping(value = {"/retrieveCustomerDetails/", "/retrieveCustomerDetails/{customerRef}"})
    @ResponseBody
    public List<Customer> retrieveCustomerDetails(@PathVariable(required = false) String customerRef) {
        if (StringUtils.isEmpty(customerRef)) {
            LOGGER.info("Retrieving all customer details");
            return customerRepository.findAll();
        } else {
            LOGGER.info("Retrieving for customerRef {}", customerRef);
            Customer customer = customerRepository.findByRefCustomer(customerRef);
            if (customer == null) {
                LOGGER.warn("customerRef {} not found", customerRef);
                throw new NotFoundException();
            }
            return Arrays.asList(customerRepository.findByRefCustomer(customerRef));
        }
    }

    /**
     * @param name
     * @return List<Customer>
     * Find all customers that have contains string parameter name
     */
    @GetMapping(value = {"/searchForCustomerByName/{name}"})
    @ResponseBody
    public List<Customer> searchForCustomerByName(@PathVariable String name) {
        LOGGER.info("searchForCustomerByName {}", name);
        if (!StringUtils.isEmpty(name)) {
            return customerRepository.findAllByCustomerContactDetails_ContactName(name.toLowerCase());
        } else {
            LOGGER.warn("name {} is empty", name);
            throw new BadRequestException();
        }
    }

    /**
     * @return List<CustomerSharesDetailsDTO>
     * Query to return information about
     * a.	ID
     * b.	Customer Name
     * c.	Date Birth/Incorporated
     * d.	Customer Type
     * e.	Number of Shares
     * f.	Share Price Per unit
     * g.	Balance (Number of Shares * Share Price per unit)
     */
    @GetMapping(value = {"/retrieveCustomerDetailsWithBalance/"})
    @ResponseBody
    public List<CustomerSharesDetailsDTO> retrieveCustomerDetailsWithBalance() {
        return customerRepository.retrieveCustomerDetailsAsDTO();
    }

    /**
     * @param customerRef
     * @param sharesDetailsVO
     * @return update of specific records.
     */
    @PutMapping(value = {"/updateSharesDetails/{customerRef}"})
    @Transactional
    public Customer updateSharesDetails(@PathVariable String customerRef, @RequestBody SharesDetailsTypeVO sharesDetailsVO) {
        LOGGER.info("START updateSharesDetails for customer {}, sharesDetailsVO {} ", customerRef, sharesDetailsVO);
        Customer customer = null;
        if (sharesDetailsVO != null) {
            customer = customerRepository.findByRefCustomer(customerRef);
            if (customer == null) {
                LOGGER.warn("customerRef not found");
                throw new NotFoundException();
            } else {
                LOGGER.info("Updating share details for customer {} ", customer.getRefCustomer());
                CustomerSharesDetails customerSharesDetails = sharesFileDetailsAdapter.fromVO(sharesDetailsVO, customer);
                if (customerSharesDetails != null) {
                    customerSharesDetailsRepository.save(customerSharesDetails);
                }
            }
        }
        LOGGER.info("END updateSharesDetails for customer {}, sharesDetailsVO {} ", customerRef, sharesDetailsVO);
        return customer;
    }

    /**
     * @param customerRef
     * @return Response
     * Method to allow downloading of a subset of the data as CSV.
     * Can pass customerRef as parameter to retrieve information of that customer
     */
    @GetMapping(value = {"/downloadCustomerDetailsForCustomerRefAsCSV/{customerRef}"})
    public Response downloadCustomerDetailsForCustomerRefAsCSV(@PathVariable String customerRef) {
        LOGGER.info("START downloadCustomerDetailsForCustomerRefAsCSV for {} ", customerRef);
        File file = null;
        if (!StringUtils.isEmpty(customerRef)) {
            Customer customer = customerRepository.findByRefCustomer(customerRef);
            if (customer != null) {
                try {
                    file = csvFileWriter.createCsvFile(customer);
                } catch (Exception e) {
                    LOGGER.error("Error while writing csv file", e);
                }
            } else {
                throw new NotFoundException();
            }
        }
        LOGGER.info("END downloadCustomerDetailsForCustomerRefAsCSV for {} ", customerRef);
        Response.ResponseBuilder responseBuilder = Response.ok(file);
        responseBuilder.header("Content-Disposition", "attachment; filename=" + "\"" + file != null ? file.getName() : null + "\"");
        return responseBuilder.build();
    }
}
