package com.example.mcShares.model;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.io.Serializable;
import java.util.UUID;

@Entity
@Table(name = "T_CUSTOMER_MAILING_ADDRESS")
public class CustomerMailingAddress extends GenericEntityFieldsClass implements Serializable {

    private static final long serialVersionUID = -7994672530239671261L;
    @Id
    @Type(type = "org.hibernate.type.PostgresUUIDType")
    @Column(name = "ID_MAILING_ADDRESS", columnDefinition = "uuid", updatable = false)
    @GeneratedValue(generator = "uuid2")
    @GenericGenerator(name = "uuid2", strategy = "uuid2")
    private UUID idMailingAddress;

    @Column(name = "ADDRESS_LINE_1", nullable = false)
    private String addressLine1;

    @Column(name = "ADDRESS_LINE_2", nullable = false)
    private String addressLine2;

    @Column(name = "TOWN_CITY", nullable = false)
    private String townCity;

    @Column(name = "COUNTRY", nullable = false)
    private String country;

    public CustomerMailingAddress() {
    }

    public CustomerMailingAddress(String addressLine1, String addressLine2, String townCity, String country) {
        this.addressLine1 = addressLine1;
        this.addressLine2 = addressLine2;
        this.townCity = townCity;
        this.country = country;
    }

    public UUID getIdMailingAddress() {
        return idMailingAddress;
    }

    public void setIdMailingAddress(UUID idMailingAddress) {
        this.idMailingAddress = idMailingAddress;
    }

    public String getAddressLine1() {
        return addressLine1;
    }

    public void setAddressLine1(String addressLine1) {
        this.addressLine1 = addressLine1;
    }

    public String getAddressLine2() {
        return addressLine2;
    }

    public void setAddressLine2(String addressLine2) {
        this.addressLine2 = addressLine2;
    }

    public String getTownCity() {
        return townCity;
    }

    public void setTownCity(String townCity) {
        this.townCity = townCity;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }
}
