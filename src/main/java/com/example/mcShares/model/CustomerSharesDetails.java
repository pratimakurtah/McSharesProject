package com.example.mcShares.model;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.io.Serializable;
import java.util.UUID;

@Entity
@Table(name = "T_CUSTOMER_SHARES_DETAILS")
public class CustomerSharesDetails extends GenericEntityFieldsClass implements Serializable {

    private static final long serialVersionUID = -9091527342670603846L;
    @Id
    @Type(type = "org.hibernate.type.PostgresUUIDType")
    @Column(name = "ID_SHARE_DETAILS", columnDefinition = "uuid", updatable = false)
    @GeneratedValue(generator = "uuid2")
    @GenericGenerator(name = "uuid2", strategy = "uuid2")
    private UUID idShareDetails;

    @Column(name = "NUM_SHARES", nullable = false)
    private Integer numShares;

    @Column(name = "SHARE_PRICE")
    private Double sharePrice;

    @Column(name = "BALANCE")
    private Double balance;

    public CustomerSharesDetails() {
    }

    public UUID getIdShareDetails() {
        return idShareDetails;
    }

    public void setIdShareDetails(UUID idShareDetails) {
        this.idShareDetails = idShareDetails;
    }

    public Integer getNumShares() {
        return numShares;
    }

    public void setNumShares(Integer numShares) {
        this.numShares = numShares;
    }

    public Double getSharePrice() {
        return sharePrice;
    }

    public void setSharePrice(Double sharePrice) {
        this.sharePrice = sharePrice;
    }

    public Double getBalance() {
        return balance;
    }

    public void setBalance(Double balance) {
        this.balance = balance;
    }
}
