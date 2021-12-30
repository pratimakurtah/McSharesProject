package com.example.mcShares.vo;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each
 * Java content interface and Java element interface
 * generated in the com.example.mcShares.vo package.
 * <p>An ObjectFactory allows you to programatically
 * construct new instances of the Java representation
 * for XML content. The Java representation of XML
 * content can consist of schema derived interfaces
 * and classes representing the binding of schema
 * type definitions, element declarations and model
 * groups.  Factory methods for each of these are
 * provided in this class.
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _RequestDoc_QNAME = new QName("", "RequestDoc");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: com.example.mcShares.vo
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link RequestDocVO }
     */
    public RequestDocVO createRequestDoc() {
        return new RequestDocVO();
    }

    /**
     * Create an instance of {@link SharesDetailsTypeVO }
     */
    public SharesDetailsTypeVO createSharesDetailsType() {
        return new SharesDetailsTypeVO();
    }

    /**
     * Create an instance of {@link DataItemCustomerVO }
     */
    public DataItemCustomerVO createDataItemCustomerVOType() {
        return new DataItemCustomerVO();
    }

    /**
     * Create an instance of {@link MailingAddressVO }
     */
    public MailingAddressVO createMailingAddressVO() {
        return new MailingAddressVO();
    }

    /**
     * Create an instance of {@link ContactDetailsVO }
     */
    public ContactDetailsVO createContactDetailsVO() {
        return new ContactDetailsVO();
    }

    /**
     * Create an instance of {@link DocDataVO }
     */
    public DocDataVO createDocDataType() {
        return new DocDataVO();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link RequestDocVO }{@code >}}
     */
    @XmlElementDecl(namespace = "", name = "RequestDoc")
    public JAXBElement<RequestDocVO> createRequestDoc(RequestDocVO value) {
        return new JAXBElement<RequestDocVO>(_RequestDoc_QNAME, RequestDocVO.class, null, value);
    }

}
