package com.example.mcShares.adapter;

import com.example.mcShares.model.*;
import com.example.mcShares.repository.ICustomerTypeRepository;
import com.example.mcShares.utils.Constants;
import com.example.mcShares.utils.FormattingUtil;
import com.example.mcShares.validation.SharesFileUploadStatusEnum;
import com.example.mcShares.validation.SharesFileValidationErrorsEnum;
import com.example.mcShares.vo.ContactDetailsVO;
import com.example.mcShares.vo.DataItemCustomerVO;
import com.example.mcShares.vo.MailingAddressVO;
import com.example.mcShares.vo.SharesDetailsTypeVO;
import org.apache.cxf.common.util.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.util.ObjectUtils;

import javax.annotation.Resource;
import javax.ws.rs.BadRequestException;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.Date;

/**
 * Class to map entity to vo and vis versa
 */
@Component
public class SharesFileDetailsAdapter {

    private static final Logger LOGGER = LoggerFactory.getLogger(SharesFileDetailsAdapter.class);
    @Resource
    private ICustomerTypeRepository customerTypeServiceDAO;
    @Resource
    private FormattingUtil formattingUtil;

    public CustomerSharesDetails fromVO(SharesDetailsTypeVO sharesDetailsTypeVO, Customer customer) {
        CustomerSharesDetails customerSharesDetails = null;
        if (customer.getCustomerSharesDetails() != null) {
            customerSharesDetails = customer.getCustomerSharesDetails();

            if (!customer.getCustomerType().getLibCustomerType().equalsIgnoreCase(Constants.CUSTOMER_TYPE_CORPORATE)) {
                String numShares = sharesDetailsTypeVO.getNumShares();
                if (validateNumShares(numShares)) {
                    customerSharesDetails.setNumShares(Integer.parseInt(sharesDetailsTypeVO.getNumShares()));
                } else {
                    throw new BadRequestException(SharesFileValidationErrorsEnum.INVALID_NUMBER_OF_SHARES.getMessage());
                }
            }
            String sharePrice = sharesDetailsTypeVO.getSharePrice();
            if (validateSharePrice(sharePrice)) {
                customerSharesDetails.setSharePrice(Double.parseDouble(sharesDetailsTypeVO.getSharePrice()));
            } else {
                throw new BadRequestException(SharesFileValidationErrorsEnum.INVALID_SHARE_PRICE.getMessage());
            }
            customerSharesDetails.setBalance(customerSharesDetails.getNumShares() * customerSharesDetails.getSharePrice());
        }
        return customerSharesDetails;
    }

    public Customer fromVO(DataItemCustomerVO dataItemCustomerVO, SharesFileUpload sharesFileUpload) {
        Customer customer = new Customer(dataItemCustomerVO.getCustomerId()
                , customerTypeServiceDAO.findByLibCustomerType(dataItemCustomerVO.getCustomerType())
                , dataItemCustomerVO.getRegistrationNo());

        Date dateOfBirth = null;
        if (!StringUtils.isEmpty(dataItemCustomerVO.getDateOfBirth())) {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
            if (dataItemCustomerVO.getCustomerType().equalsIgnoreCase(Constants.CUSTOMER_TYPE_INDIVIDUAL)) {
                LocalDate localDate = LocalDate.parse(dataItemCustomerVO.getDateOfBirth(), formatter);
                Period period = Period.between(localDate, LocalDate.now());
                int age = period.getYears();
                if (age < 18) {
                    LOGGER.error("Error for customer {}, date of birth {} : {} ", dataItemCustomerVO.getCustomerId(), dateOfBirth, SharesFileValidationErrorsEnum.CUSTOMER_AGE_INVALID);
                    setFileUploadStatus(sharesFileUpload, SharesFileUploadStatusEnum.PARTIAL);
                    return null;
                } else {
                    dateOfBirth = formattingUtil.convertStringToDate(dataItemCustomerVO.getDateOfBirth());
                }
            }
            customer.setDateOfBirth(dateOfBirth);
        } else {
            return null;
        }

        Date dateIncorp = null;
        if (!StringUtils.isEmpty(dataItemCustomerVO.getDateIncorp())) {
            dateIncorp = formattingUtil.convertStringToDate(dataItemCustomerVO.getDateIncorp());
            customer.setDateIncorp(dateIncorp);
        }

        if (!ObjectUtils.isEmpty(dataItemCustomerVO.getMailingAddress())) {
            MailingAddressVO mailingAddressVO = dataItemCustomerVO.getMailingAddress();

            CustomerMailingAddress customerMailingAddress = new CustomerMailingAddress(mailingAddressVO.getAddressLine1()
                    , mailingAddressVO.getAddressLine2()
                    , mailingAddressVO.getTownCity()
                    , mailingAddressVO.getCountry());
            customer.setCustomerMailingAddress(customerMailingAddress);
        }

        if (!ObjectUtils.isEmpty(dataItemCustomerVO.getContactDetails())) {
            ContactDetailsVO contactDetailsVO = dataItemCustomerVO.getContactDetails();
            CustomerContactDetails customerContactDetails = new CustomerContactDetails(contactDetailsVO.getContactName(), contactDetailsVO.getContactNumber());
            customer.setCustomerContactDetails(customerContactDetails);
        }

        if (dataItemCustomerVO.getSharesDetails() != null) {
            CustomerSharesDetails customerSharesDetails = new CustomerSharesDetails();

            String numShares = dataItemCustomerVO.getSharesDetails().getNumShares();
            if (!validateNumShares(numShares)) {
                LOGGER.error("Error for customer {}, num shares {} : {} ", dataItemCustomerVO.getCustomerId(), numShares, SharesFileValidationErrorsEnum.INVALID_NUMBER_OF_SHARES);
                setFileUploadStatus(sharesFileUpload, SharesFileUploadStatusEnum.PARTIAL);
                return null;
            } else {
                customerSharesDetails.setNumShares(Integer.parseInt(numShares));
            }

            String sharePrice = dataItemCustomerVO.getSharesDetails().getSharePrice();
            if (!validateSharePrice(sharePrice)) {
                LOGGER.error("Error for customer {}, num shares {} : {} ", dataItemCustomerVO.getCustomerId(), numShares, SharesFileValidationErrorsEnum.INVALID_SHARE_PRICE);
                setFileUploadStatus(sharesFileUpload, SharesFileUploadStatusEnum.PARTIAL);
                return null;
            } else {
                customerSharesDetails.setSharePrice(Double.parseDouble(sharePrice));
            }

            customerSharesDetails.setBalance(customerSharesDetails.getSharePrice() * customerSharesDetails.getNumShares());
            customer.setCustomerSharesDetails(customerSharesDetails);
        }

        setFileUploadStatus(sharesFileUpload, SharesFileUploadStatusEnum.SUCCESS);

        return customer;
    }

    private boolean validateSharePrice(String sharePrice) {
        return !StringUtils.isEmpty(sharePrice) && formattingUtil.isNumeric(sharePrice) && BigDecimal.valueOf(Double.parseDouble(sharePrice)).scale() <= 2;
    }

    private boolean validateNumShares(String numShares) {
        return !StringUtils.isEmpty(numShares) && formattingUtil.isInt(numShares) && Integer.parseInt(numShares) > 0;
    }

    private void setFileUploadStatus(SharesFileUpload sharesFileUpload, SharesFileUploadStatusEnum success) {
        if (sharesFileUpload != null) {
            sharesFileUpload.setStatus(success.toString());
        }
    }
}
