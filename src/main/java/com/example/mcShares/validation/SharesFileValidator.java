package com.example.mcShares.validation;

import com.example.mcShares.vo.RequestDocVO;
import com.example.mcShares.vo.ResponseVO;
import org.apache.cxf.staxutils.StaxSource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;
import org.xml.sax.SAXException;

import javax.xml.XMLConstants;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import javax.xml.validation.Validator;
import java.io.*;
import java.util.Locale;

/**
 * Class to do all validations on xml file being uploaded
 * Convert multipart to xml
 * convert to vo
 */
@Component
public class SharesFileValidator {

    private static final String XML_EXTENSION = ".xml";
    private static final String XSD = "src/main/resources/mcSharesFile/McShares_2018_xsd.xsd";
    private static final String LOCALE_KEY = "http://apache.org/xml/properties/locale";
    private final Logger LOGGER = LoggerFactory.getLogger(SharesFileValidator.class);

    public ResponseVO validateSharesFile(MultipartFile multipartFile) {
        LOGGER.info("START validateSharesFile() filename : {} ", multipartFile.getOriginalFilename());

        final String errorMessage = "Error : {} ";
        if (multipartFile.getSize() == 0) {
            LOGGER.error(errorMessage, SharesFileValidationErrorsEnum.FILE_EMPTY_OR_FILE_NULL);
            return new ResponseVO(HttpStatus.NO_CONTENT.value(), SharesFileValidationErrorsEnum.FILE_EMPTY_OR_FILE_NULL.toString(), SharesFileValidationErrorsEnum.FILE_EMPTY_OR_FILE_NULL.name(), SharesFileUploadStatusEnum.FAILED.name());
        }

        if (multipartFile.getOriginalFilename() != null && !multipartFile.getOriginalFilename().toLowerCase().endsWith(XML_EXTENSION)) {
            LOGGER.error(errorMessage, SharesFileValidationErrorsEnum.INVALID_EXTENSION);
            return new ResponseVO(HttpStatus.UNSUPPORTED_MEDIA_TYPE.value(), SharesFileValidationErrorsEnum.INVALID_EXTENSION.toString(), SharesFileValidationErrorsEnum.INVALID_EXTENSION.name(), SharesFileUploadStatusEnum.FAILED.name());
        }

        byte[] buffer = new byte[0];
        File xmlFile = getXMLFile(multipartFile, buffer);
        if (!validateAgainstXSD(xmlFile)) {
            LOGGER.error(errorMessage, SharesFileValidationErrorsEnum.XSD_ERROR);
            return new ResponseVO(HttpStatus.UNPROCESSABLE_ENTITY.value(), SharesFileValidationErrorsEnum.XSD_ERROR.toString(), SharesFileValidationErrorsEnum.XSD_ERROR.name(), SharesFileUploadStatusEnum.FAILED.name());
        }

        LOGGER.info("END validateSharesFile() filename : {} ", multipartFile.getOriginalFilename());
        return null;
    }

    public boolean validateAgainstXSD(File xmlFile) {
        boolean isValid = false;

        //Validator
        try {
            SchemaFactory factory = SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);
            Schema schema = factory.newSchema(new File(XSD));
            Validator schemaValidator = schema.newValidator();
            schemaValidator.setProperty(LOCALE_KEY, Locale.ROOT);

            XMLInputFactory xmlInputFactory = XMLInputFactory.newInstance();
            FileInputStream fileInputStream = new FileInputStream(xmlFile);
            XMLStreamReader xmlStreamReader = xmlInputFactory.createXMLStreamReader(fileInputStream);

            StaxSource source = new StaxSource(xmlStreamReader);
            schemaValidator.validate(source);
            isValid = true;
        } catch (SAXException e) {
            LOGGER.error("SAXException", e);
        } catch (FileNotFoundException e) {
            LOGGER.error("FileNotFoundException ", e);
        } catch (XMLStreamException e) {
            LOGGER.error("XMLStreamException ", e);
        } catch (IOException e) {
            LOGGER.error("IOException ", e);
        }

        return isValid;
    }

    private File getXMLFile(MultipartFile multipartFile, byte[] buffer) {
        File xmlFile = new File("src/main/resources/xmlFile.tmp");

        //XML File
        InputStream initialStream = null;
        try {
            initialStream = multipartFile.getInputStream();
            buffer = new byte[initialStream.available()];
            initialStream.read(buffer);
        } catch (IOException e) {
            e.printStackTrace();
        }

        try (OutputStream outStream = new FileOutputStream(xmlFile)) {
            outStream.write(buffer);
        } catch (FileNotFoundException e) {
            LOGGER.error("FileNotFoundException ", e);
        } catch (IOException e) {
            LOGGER.error("IOException ", e);
        }
        return xmlFile;
    }

    public RequestDocVO unmarshallDocData(MultipartFile multipartFile) {
        InputStream fileStream = null;

        try {
            fileStream = multipartFile.getInputStream();
        } catch (IOException e) {
            e.printStackTrace();
        }

        JAXBContext jaxbContext;
        RequestDocVO requestDocVO = null;
        try {
            jaxbContext = JAXBContext.newInstance(RequestDocVO.class);
            Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
            requestDocVO = (RequestDocVO) jaxbUnmarshaller.unmarshal(fileStream);
        } catch (JAXBException e) {
            e.printStackTrace();
        }

        return requestDocVO;
    }
}
