package com.example.mcShares.model;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.UUID;

@Entity
@Table(name = "T_SHARES_FILE_UPLOAD")
public class SharesFileUpload extends GenericEntityFieldsClass implements Serializable {

    private static final long serialVersionUID = -1659731156431021471L;

    @Id
    @Type(type = "org.hibernate.type.PostgresUUIDType")
    @Column(name = "ID_SHARES_FILE_UPLOAD", columnDefinition = "uuid")
    @GeneratedValue(generator = "uuid2")
    @GenericGenerator(name = "uuid2", strategy = "uuid2")
    private UUID idSharesFileUpload;

    @Column(name = "FILE_NAME", nullable = false)
    private String fileName;

    @Column(name = "DOC_REF", nullable = false)
    private String docRef;

    @Column(name = "DOC_DATE", nullable = false)
    private Date docDate;

    @Column(name = "STATUS")
    private String status;

    public SharesFileUpload() {
    }

    public SharesFileUpload(UUID idSharesFileUpload, String fileName, String docRef, Date docDate, String status) {
        this.idSharesFileUpload = idSharesFileUpload;
        this.fileName = fileName;
        this.docRef = docRef;
        this.docDate = docDate;
        this.status = status;
    }

    public SharesFileUpload(String fileName, String docRef, Date docDate, String status) {
        this.fileName = fileName;
        this.docRef = docRef;
        this.docDate = docDate;
        this.status = status;
    }

    public UUID getIdSharesFileUpload() {
        return idSharesFileUpload;
    }

    public void setIdSharesFileUpload(UUID idSharesFileUpload) {
        this.idSharesFileUpload = idSharesFileUpload;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public String getDocRef() {
        return docRef;
    }

    public void setDocRef(String docRef) {
        this.docRef = docRef;
    }

    public Date getDocDate() {
        return docDate;
    }

    public void setDocDate(Date docDate) {
        this.docDate = docDate;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
