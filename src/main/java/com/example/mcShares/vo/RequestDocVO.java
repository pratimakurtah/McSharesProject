package com.example.mcShares.vo;

import javax.xml.bind.annotation.*;


/**
 * <p>Java class for RequestDoc complex type.
 *
 * <p>The following schema fragment specifies the expected content contained within this class.
 *
 * <pre>
 * &lt;complexType name="RequestDoc">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="Doc_Date" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="Doc_Ref" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="Doc_Data" type="{}Doc_DataType"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 */
@XmlRootElement(name = "RequestDoc")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "RequestDocVO", propOrder = {
        "docDate",
        "docRef",
        "docDataVO"
})
public class RequestDocVO {

    @XmlElement(name = "Doc_Date", required = true)
    protected String docDate;
    @XmlElement(name = "Doc_Ref", required = true)
    protected String docRef;
    @XmlElement(name = "Doc_Data", required = true)
    protected DocDataVO docDataVO;

    /**
     * Gets the value of the docDate property.
     *
     * @return possible object is
     * {@link String }
     */
    public String getDocDate() {
        return docDate;
    }

    /**
     * Sets the value of the docDate property.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setDocDate(String value) {
        this.docDate = value;
    }

    /**
     * Gets the value of the docRef property.
     *
     * @return possible object is
     * {@link String }
     */
    public String getDocRef() {
        return docRef;
    }

    /**
     * Sets the value of the docRef property.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setDocRef(String value) {
        this.docRef = value;
    }

    /**
     * Gets the value of the docData property.
     *
     * @return possible object is
     * {@link DocDataVO }
     */
    public DocDataVO getDocData() {
        return docDataVO;
    }

    /**
     * Sets the value of the docData property.
     *
     * @param value allowed object is
     *              {@link DocDataVO }
     */
    public void setDocData(DocDataVO value) {
        this.docDataVO = value;
    }

}
