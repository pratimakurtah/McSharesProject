package com.example.mcShares.dto;

import java.io.Serializable;
import java.util.Date;

public class CustomerSharesDetailsDTO implements Serializable {

    private String id;
    private String customerName;
    private Date dateOfBith;
    private String customerType;
    private Integer numberOfShares;
    private Double sharePricePerUnit;
    private Double balance;

    public CustomerSharesDetailsDTO(String id, String customerName, Date dateOfBith, String customerType, Integer numberOfShares, Double sharePricePerUnit, Double balance) {
        this.id = id;
        this.customerName = customerName;
        this.dateOfBith = dateOfBith;
        this.customerType = customerType;
        this.numberOfShares = numberOfShares;
        this.sharePricePerUnit = sharePricePerUnit;
        this.balance = balance;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public Date getDateOfBith() {
        return dateOfBith;
    }

    public void setDateOfBith(Date dateOfBith) {
        this.dateOfBith = dateOfBith;
    }

    public String getCustomerType() {
        return customerType;
    }

    public void setCustomerType(String customerType) {
        this.customerType = customerType;
    }

    public Integer getNumberOfShares() {
        return numberOfShares;
    }

    public void setNumberOfShares(Integer numberOfShares) {
        this.numberOfShares = numberOfShares;
    }

    public Double getSharePricePerUnit() {
        return sharePricePerUnit;
    }

    public void setSharePricePerUnit(Double sharePricePerUnit) {
        this.sharePricePerUnit = sharePricePerUnit;
    }

    public Double getBalance() {
        return balance;
    }

    public void setBalance(Double balance) {
        this.balance = balance;
    }
}
