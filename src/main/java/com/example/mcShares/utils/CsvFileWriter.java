package com.example.mcShares.utils;

import com.example.mcShares.model.Customer;
import com.example.mcShares.model.CustomerContactDetails;
import com.example.mcShares.model.CustomerMailingAddress;
import com.example.mcShares.model.CustomerSharesDetails;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVPrinter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

@Component
public class CsvFileWriter {

    private static final Logger LOGGER = LoggerFactory.getLogger(CsvFileWriter.class);

    private final String[] HEADERS = {"customer_id", "Customer_Type", "Date_Of_Birth", "Date_Incorp",
            "registration_no", "Address_Line1", "Address_Line2", "Town_City", "Country", "Contact_Name", "Contact_Number", "Num_Shares", "Share_Price", "Balance"};

    private String csvFilePrefix = "customer_details_";

    private String getCsvFileName(String customerRef) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("ddMMyyyy");
        return csvFilePrefix + customerRef + "_" + simpleDateFormat.format(new Date()) + ".csv";
    }

    public File createCsvFile(Customer customer) {
        String csvFileName = getCsvFileName(customer.getRefCustomer());
        File file = new File("c://dev/extraction/" + csvFileName);

        if (file.exists()) {
            LOGGER.info("Details of customer {} already exists in csv file {}", customer.getRefCustomer(), csvFileName);
            return file;
        }

        LOGGER.info("START Writing details of customer {} to csv file {}", customer.getRefCustomer(), csvFileName);

        FileWriter out = null;
        CSVPrinter csvPrinter = null;

        try {
            out = new FileWriter(file);
            csvPrinter = new CSVPrinter(out, CSVFormat.DEFAULT.withHeader(HEADERS));
        } catch (IOException e) {
            LOGGER.error("IOException ", e);
        }

        CustomerMailingAddress customerMailingAddress = customer.getCustomerMailingAddress();
        CustomerContactDetails customerContactDetails = customer.getCustomerContactDetails();
        CustomerSharesDetails customerSharesDetails = customer.getCustomerSharesDetails();

        try {
            csvPrinter.printRecord(customer.getRefCustomer(),
                    customer.getCustomerType().getLibCustomerType(),
                    customer.getDateOfBirth(),
                    customer.getDateIncorp(),
                    customer.getRegistrationNumber(),
                    customerMailingAddress.getAddressLine1(),
                    customerMailingAddress.getAddressLine2(),
                    customerMailingAddress.getTownCity(),
                    customerMailingAddress.getCountry(),
                    customerContactDetails.getContactName(),
                    customerContactDetails.getContactNumber(),
                    customerSharesDetails.getNumShares(),
                    customerSharesDetails.getSharePrice(),
                    customerSharesDetails.getBalance()
            );
        } catch (IOException e) {
            LOGGER.error("Error while writing details of customer {} to csv file {}", customer.getRefCustomer(), csvFileName, e);
        }

        try {
            csvPrinter.close();
            out.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        LOGGER.info("START Writing details of customer {} to csv file {}", customer.getRefCustomer(), csvFileName);

        return file;
    }
}
