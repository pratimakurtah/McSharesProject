package com.example.mcShares.model;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.io.Serializable;
import java.util.UUID;


@Entity
@Table(name = "T_CUSTOMER_CONTACT_DETAILS")
public class CustomerContactDetails extends GenericEntityFieldsClass implements Serializable {

    private static final long serialVersionUID = 6248388288539887262L;
    @Id
    @Type(type = "org.hibernate.type.PostgresUUIDType")
    @Column(name = "ID_CONTACT_DETAILS", columnDefinition = "uuid", updatable = false)
    @GeneratedValue(generator = "uuid2")
    @GenericGenerator(name = "uuid2", strategy = "uuid2")
    private UUID idContactDetails;

    @Column(name = "CONTACT_NAME", nullable = false)
    private String contactName;

    @Column(name = "CONTACT_NUMBER")
    private String contactNumber;

    public CustomerContactDetails() {
    }

    public CustomerContactDetails(String contactName, String contactNumber) {
        this.contactName = contactName;
        this.contactNumber = contactNumber;
    }

    public UUID getIdContactDetails() {
        return idContactDetails;
    }

    public void setIdContactDetails(UUID idContactDetails) {
        this.idContactDetails = idContactDetails;
    }

    public String getContactName() {
        return contactName;
    }

    public void setContactName(String contactName) {
        this.contactName = contactName;
    }

    public String getContactNumber() {
        return contactNumber;
    }

    public void setContactNumber(String contactNumber) {
        this.contactNumber = contactNumber;
    }
}
