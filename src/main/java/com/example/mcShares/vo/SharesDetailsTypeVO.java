package com.example.mcShares.vo;

import javax.xml.bind.annotation.*;


/**
 * <p>Java class for Shares_DetailsType complex type.
 *
 * <p>The following schema fragment specifies the expected content contained within this class.
 *
 * <pre>
 * &lt;complexType name="Shares_DetailsType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="Num_Shares">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *               &lt;enumeration value="10200"/>
 *               &lt;enumeration value="4000"/>
 *               &lt;enumeration value="63000"/>
 *               &lt;enumeration value="2000"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="Share_Price">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *               &lt;enumeration value="11.40"/>
 *               &lt;enumeration value="9.20"/>
 *               &lt;enumeration value="12.20"/>
 *               &lt;enumeration value="365.20"/>
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
@XmlType(name = "Shares_DetailsType", propOrder = {
        "numShares",
        "sharePrice"
})
public class SharesDetailsTypeVO {

    @XmlElement(name = "Num_Shares", required = true)
    protected String numShares;
    @XmlElement(name = "Share_Price", required = true)
    protected String sharePrice;
    @XmlTransient
    protected String balance;

    public SharesDetailsTypeVO() {
    }

    public SharesDetailsTypeVO(String numShares, String sharePrice, String balance) {
        this.numShares = numShares;
        this.sharePrice = sharePrice;
        this.balance = balance;
    }

    /**
     * Gets the value of the numShares property.
     *
     * @return possible object is
     * {@link String }
     */
    public String getNumShares() {
        return numShares;
    }

    /**
     * Sets the value of the numShares property.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setNumShares(String value) {
        this.numShares = value;
    }

    /**
     * Gets the value of the sharePrice property.
     *
     * @return possible object is
     * {@link String }
     */
    public String getSharePrice() {
        return sharePrice;
    }

    /**
     * Sets the value of the sharePrice property.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setSharePrice(String value) {
        this.sharePrice = value;
    }

    public String getBalance() {
        return balance;
    }

    public void setBalance(String balance) {
        this.balance = balance;
    }

    @Override
    public String toString() {
        return "SharesDetailsTypeVO{" +
                "numShares='" + numShares + '\'' +
                ", sharePrice='" + sharePrice + '\'' +
                '}';
    }
}
