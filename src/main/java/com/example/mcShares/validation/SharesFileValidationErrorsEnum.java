package com.example.mcShares.validation;

/**
 * Different errors that can affect occur when validating data in xml file
 */
public enum SharesFileValidationErrorsEnum {

    CUSTOMER_AGE_INVALID("For individuals, customer must be at least 18 years old"),
    FILE_EMPTY_OR_FILE_NULL("Shares file is empty or No file"),
    INVALID_EXTENSION("File should have .xml extension"),
    INVALID_NUMBER_OF_SHARES("Number of shares must be an integer and greater than 0"),
    INVALID_SHARE_PRICE("Share_price must be a number greater than 0 and up to two decimal places"),
    XSD_ERROR("File does not conform to XSD");

    public String message;

    SharesFileValidationErrorsEnum(String message) {
        message = message;
    }

    public String getMessage() {
        return message;
    }


}
