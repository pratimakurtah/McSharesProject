package com.example.mcShares.validation;

/**
 * Types of status that a file can have after upload
 */
public enum SharesFileUploadStatusEnum {

    /**
     * All customer data in shares file have been persisted
     */
    SUCCESS,

    /**
     * Some customer data in shares file have been persisted, data in file partially saved
     */
    PARTIAL,

    /**
     * No customer data in shares file have been persisted, whole file rejected
     */
    FAILED
}
