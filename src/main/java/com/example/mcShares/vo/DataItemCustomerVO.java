package com.example.mcShares.vo;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for DataItem_CustomerType complex type.
 *
 * <p>The following schema fragment specifies the expected content contained within this class.
 *
 * <pre>
 * &lt;complexType name="DataItem_CustomerType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="customer_id">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *               &lt;enumeration value="C11233"/>
 *               &lt;enumeration value="D43764"/>
 *               &lt;enumeration value="H15676"/>
 *               &lt;enumeration value="T90897"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="Customer_Type">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *               &lt;enumeration value="Individual"/>
 *               &lt;enumeration value="Corporate"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="Date_Of_Birth">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *               &lt;enumeration value="19/07/1987"/>
 *               &lt;enumeration value=""/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="Date_Incorp">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *               &lt;enumeration value=""/>
 *               &lt;enumeration value="01/07/2012"/>
 *               &lt;enumeration value="14/01/2002"/>
 *               &lt;enumeration value="20/08/2003"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="REGISTRATION_NO" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Registration_No" minOccurs="0">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *               &lt;enumeration value="R14023581"/>
 *               &lt;enumeration value="R10411524"/>
 *               &lt;enumeration value="R156925840"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="Mailing_Address" type="{}Mailing_AddressType"/>
 *         &lt;element name="Contact_Details" type="{}Contact_DetailsType"/>
 *         &lt;element name="Shares_Details" type="{}Shares_DetailsType"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "DataItem_CustomerType", propOrder = {
        "customerId",
        "customerType",
        "dateOfBirth",
        "dateIncorp",
        "registrationno",
        "registrationNo",
        "mailingAddress",
        "contactDetails",
        "sharesDetails"
})
public class DataItemCustomerVO {

    @XmlElement(name = "customer_id", required = true)
    protected String customerId;
    @XmlElement(name = "Customer_Type", required = true)
    protected String customerType;
    @XmlElement(name = "Date_Of_Birth", required = true)
    protected String dateOfBirth;
    @XmlElement(name = "Date_Incorp", required = true)
    protected String dateIncorp;
    @XmlElement(name = "REGISTRATION_NO")
    protected String registrationno;
    @XmlElement(name = "Registration_No")
    protected String registrationNo;
    @XmlElement(name = "Mailing_Address", required = true)
    protected MailingAddressVO mailingAddress;
    @XmlElement(name = "Contact_Details", required = true)
    protected ContactDetailsVO contactDetails;
    @XmlElement(name = "Shares_Details", required = true)
    protected SharesDetailsTypeVO sharesDetails;

    /**
     * Gets the value of the customerId property.
     *
     * @return possible object is
     * {@link String }
     */
    public String getCustomerId() {
        return customerId;
    }

    /**
     * Sets the value of the customerId property.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setCustomerId(String value) {
        this.customerId = value;
    }

    /**
     * Gets the value of the customerType property.
     *
     * @return possible object is
     * {@link String }
     */
    public String getCustomerType() {
        return customerType;
    }

    /**
     * Sets the value of the customerType property.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setCustomerType(String value) {
        this.customerType = value;
    }

    /**
     * Gets the value of the dateOfBirth property.
     *
     * @return possible object is
     * {@link String }
     */
    public String getDateOfBirth() {
        return dateOfBirth;
    }

    /**
     * Sets the value of the dateOfBirth property.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setDateOfBirth(String value) {
        this.dateOfBirth = value;
    }

    /**
     * Gets the value of the dateIncorp property.
     *
     * @return possible object is
     * {@link String }
     */
    public String getDateIncorp() {
        return dateIncorp;
    }

    /**
     * Sets the value of the dateIncorp property.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setDateIncorp(String value) {
        this.dateIncorp = value;
    }

    /**
     * Gets the value of the registrationno property.
     *
     * @return possible object is
     * {@link String }
     */
    public String getREGISTRATIONNO() {
        return registrationno;
    }

    /**
     * Sets the value of the registrationno property.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setREGISTRATIONNO(String value) {
        this.registrationno = value;
    }

    /**
     * Gets the value of the registrationNo property.
     *
     * @return possible object is
     * {@link String }
     */
    public String getRegistrationNo() {
        return registrationNo;
    }

    /**
     * Sets the value of the registrationNo property.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setRegistrationNo(String value) {
        this.registrationNo = value;
    }

    /**
     * Gets the value of the mailingAddress property.
     *
     * @return possible object is
     * {@link MailingAddressVO }
     */
    public MailingAddressVO getMailingAddress() {
        return mailingAddress;
    }

    /**
     * Sets the value of the mailingAddress property.
     *
     * @param value allowed object is
     *              {@link MailingAddressVO }
     */
    public void setMailingAddress(MailingAddressVO value) {
        this.mailingAddress = value;
    }

    /**
     * Gets the value of the contactDetails property.
     *
     * @return possible object is
     * {@link ContactDetailsVO }
     */
    public ContactDetailsVO getContactDetails() {
        return contactDetails;
    }

    /**
     * Sets the value of the contactDetails property.
     *
     * @param value allowed object is
     *              {@link ContactDetailsVO }
     */
    public void setContactDetails(ContactDetailsVO value) {
        this.contactDetails = value;
    }

    /**
     * Gets the value of the sharesDetails property.
     *
     * @return possible object is
     * {@link SharesDetailsTypeVO }
     */
    public SharesDetailsTypeVO getSharesDetails() {
        return sharesDetails;
    }

    /**
     * Sets the value of the sharesDetails property.
     *
     * @param value allowed object is
     *              {@link SharesDetailsTypeVO }
     */
    public void setSharesDetails(SharesDetailsTypeVO value) {
        this.sharesDetails = value;
    }

}
