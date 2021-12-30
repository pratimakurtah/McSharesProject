package com.example.mcShares.model;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.UUID;

@Entity
@Table(name = "T_CUSTOMER")
public class Customer extends GenericEntityFieldsClass implements Serializable {

    private static final long serialVersionUID = -8594811852664521990L;
    @Id
    @Column(name = "ID_CUSTOMER", columnDefinition = "uuid", updatable = false)
    @GeneratedValue(generator = "uuid2")
    @GenericGenerator(name = "uuid2", strategy = "uuid2")
    @Type(type = "org.hibernate.type.PostgresUUIDType")
    private UUID idCustomer;

    @Column(name = "REF_CUSTOMER")
    private String refCustomer;

    @OneToOne
    @JoinColumn(name = "ID_CUSTOMER_TYPE", nullable = false)
    private CustomerType customerType;

    @Column(name = "DATE_OF_BIRTH")
    private Date dateOfBirth;

    @Column(name = "DATE_INCORP", nullable = true)
    private Date dateIncorp;

    @Column(name = "REGISTRATION_NO")
    private String registrationNumber;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "ID_MAILING_ADDRESS", updatable = true)
    private CustomerMailingAddress customerMailingAddress;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "ID_CONTACT_DETAILS", updatable = true)
    private CustomerContactDetails customerContactDetails;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "ID_SHARE_DETAILS", updatable = true)
    private CustomerSharesDetails customerSharesDetails;

    public Customer() {
    }

    public Customer(String refCustomer, CustomerType customerType, String registrationNumber) {
        this.refCustomer = refCustomer;
        this.customerType = customerType;
        this.registrationNumber = registrationNumber;
    }

    public String getRefCustomer() {
        return refCustomer;
    }

    public void setRefCustomer(String refCustomer) {
        this.refCustomer = refCustomer;
    }

    public CustomerType getCustomerType() {
        return customerType;
    }

    public void setCustomerType(CustomerType customerType) {
        this.customerType = customerType;
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public Date getDateIncorp() {
        return dateIncorp;
    }

    public void setDateIncorp(Date dateIncorp) {
        this.dateIncorp = dateIncorp;
    }

    public String getRegistrationNumber() {
        return registrationNumber;
    }

    public void setRegistrationNumber(String registrationNumber) {
        this.registrationNumber = registrationNumber;
    }

    public CustomerMailingAddress getCustomerMailingAddress() {
        return customerMailingAddress;
    }

    public void setCustomerMailingAddress(CustomerMailingAddress customerMailingAddress) {
        this.customerMailingAddress = customerMailingAddress;
    }

    public CustomerContactDetails getCustomerContactDetails() {
        return customerContactDetails;
    }

    public void setCustomerContactDetails(CustomerContactDetails customerContactDetails) {
        this.customerContactDetails = customerContactDetails;
    }

    public CustomerSharesDetails getCustomerSharesDetails() {
        return customerSharesDetails;
    }

    public void setCustomerSharesDetails(CustomerSharesDetails customerSharesDetails) {
        this.customerSharesDetails = customerSharesDetails;
    }
}
