package com.example.mcShares.vo;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for Mailing_AddressType complex type.
 *
 * <p>The following schema fragment specifies the expected content contained within this class.
 *
 * <pre>
 * &lt;complexType name="Mailing_AddressType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="Address_Line1">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *               &lt;enumeration value="21"/>
 *               &lt;enumeration value="40"/>
 *               &lt;enumeration value="50 Paul"/>
 *               &lt;enumeration value="33 St James"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="Address_Line2">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *               &lt;enumeration value="Downing Street"/>
 *               &lt;enumeration value="Morven Road"/>
 *               &lt;enumeration value="Detroit Road"/>
 *               &lt;enumeration value="Court"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="Town_City">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *               &lt;enumeration value="London"/>
 *               &lt;enumeration value="St Louis"/>
 *               &lt;enumeration value="Ohio"/>
 *               &lt;enumeration value="Port Louis"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="Country">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *               &lt;enumeration value="England"/>
 *               &lt;enumeration value="United States"/>
 *               &lt;enumeration value="Mauritius"/>
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
@XmlType(name = "Mailing_AddressType", propOrder = {
        "addressLine1",
        "addressLine2",
        "townCity",
        "country"
})
public class MailingAddressVO {

    @XmlElement(name = "Address_Line1", required = true)
    protected String addressLine1;
    @XmlElement(name = "Address_Line2", required = true)
    protected String addressLine2;
    @XmlElement(name = "Town_City", required = true)
    protected String townCity;
    @XmlElement(name = "Country", required = true)
    protected String country;

    public MailingAddressVO() {
    }

    public MailingAddressVO(String addressLine1, String addressLine2, String townCity, String country) {
        this.addressLine1 = addressLine1;
        this.addressLine2 = addressLine2;
        this.townCity = townCity;
        this.country = country;
    }

    /**
     * Gets the value of the addressLine1 property.
     *
     * @return possible object is
     * {@link String }
     */
    public String getAddressLine1() {
        return addressLine1;
    }

    /**
     * Sets the value of the addressLine1 property.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setAddressLine1(String value) {
        this.addressLine1 = value;
    }

    /**
     * Gets the value of the addressLine2 property.
     *
     * @return possible object is
     * {@link String }
     */
    public String getAddressLine2() {
        return addressLine2;
    }

    /**
     * Sets the value of the addressLine2 property.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setAddressLine2(String value) {
        this.addressLine2 = value;
    }

    /**
     * Gets the value of the townCity property.
     *
     * @return possible object is
     * {@link String }
     */
    public String getTownCity() {
        return townCity;
    }

    /**
     * Sets the value of the townCity property.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setTownCity(String value) {
        this.townCity = value;
    }

    /**
     * Gets the value of the country property.
     *
     * @return possible object is
     * {@link String }
     */
    public String getCountry() {
        return country;
    }

    /**
     * Sets the value of the country property.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setCountry(String value) {
        this.country = value;
    }

}
