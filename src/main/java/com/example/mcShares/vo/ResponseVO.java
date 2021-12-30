package com.example.mcShares.vo;

public class ResponseVO {

    private Integer httpCode;
    private String errorCode;
    private String errorMessage;
    private String fileUploadStatus;

    public ResponseVO() {
    }

    public ResponseVO(Integer httpCode, String fileUploadStatus) {
        this.fileUploadStatus = fileUploadStatus;
        this.httpCode = httpCode;
    }

    public ResponseVO(Integer httpCode, String errorCode, String errorMessage, String fileUploadStatus) {
        this.httpCode = httpCode;
        this.errorCode = errorCode;
        this.errorMessage = errorMessage;
        this.fileUploadStatus = fileUploadStatus;
    }

    public Integer getHttpCode() {
        return httpCode;
    }

    public void setHttpCode(Integer httpCode) {
        this.httpCode = httpCode;
    }

    public String getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(String errorCode) {
        this.errorCode = errorCode;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    public String getFileUploadStatus() {
        return fileUploadStatus;
    }

    public void setFileUploadStatus(String fileUploadStatus) {
        this.fileUploadStatus = fileUploadStatus;
    }
}
