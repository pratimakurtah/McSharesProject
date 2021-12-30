package com.example.mcShares.vo;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for Contact_DetailsType complex type.
 *
 * <p>The following schema fragment specifies the expected content contained within this class.
 *
 * <pre>
 * &lt;complexType name="Contact_DetailsType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="Contact_Name">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *               &lt;enumeration value="Mr John Doe"/>
 *               &lt;enumeration value="Sterling Holdings"/>
 *               &lt;enumeration value="Dellaware Ltd"/>
 *               &lt;enumeration value="Thompson Deutsche Ltd"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="Contact_Number">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *               &lt;enumeration value="7784051"/>
 *               &lt;enumeration value="4455962820"/>
 *               &lt;enumeration value=""/>
 *               &lt;enumeration value="579815662"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Contact_DetailsType", propOrder = {
        "contactName",
        "contactNumber"
})
public class ContactDetailsVO {

    @XmlElement(name = "Contact_Name", required = true)
    protected String contactName;
    @XmlElement(name = "Contact_Number", required = true)
    protected String contactNumber;

    public ContactDetailsVO() {
    }

    public ContactDetailsVO(String contactName, String contactNumber) {
        this.contactName = contactName;
        this.contactNumber = contactNumber;
    }

    /**
     * Gets the value of the contactName property.
     *
     * @return possible object is
     * {@link String }
     */
    public String getContactName() {
        return contactName;
    }

    /**
     * Sets the value of the contactName property.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setContactName(String value) {
        this.contactName = value;
    }

    /**
     * Gets the value of the contactNumber property.
     *
     * @return possible object is
     * {@link String }
     */
    public String getContactNumber() {
        return contactNumber;
    }

    /**
     * Sets the value of the contactNumber property.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setContactNumber(String value) {
        this.contactNumber = value;
    }

}
