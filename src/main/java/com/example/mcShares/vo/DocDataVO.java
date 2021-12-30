package com.example.mcShares.vo;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import java.util.ArrayList;
import java.util.List;


/**
 * <p>Java class for Doc_DataType complex type.
 *
 * <p>The following schema fragment specifies the expected content contained within this class.
 *
 * <pre>
 * &lt;complexType name="Doc_DataType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="DataItem_Customer" type="{}DataItem_CustomerType" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Doc_DataType", propOrder = {
        "DataItemCustomerVO"
})
public class DocDataVO {

    @XmlElement(name = "DataItem_Customer")
    protected List<DataItemCustomerVO> DataItemCustomerVO;

    /**
     * Gets the value of the DataItemCustomerVO property.
     *
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the DataItemCustomerVO property.
     *
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getDataItemCustomerVO().add(newItem);
     * </pre>
     *
     *
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link DataItemCustomerVO }
     */
    public List<DataItemCustomerVO> getDataItemCustomerVO() {
        if (DataItemCustomerVO == null) {
            DataItemCustomerVO = new ArrayList<DataItemCustomerVO>();
        }
        return this.DataItemCustomerVO;
    }

}
