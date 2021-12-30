package com.example.mcShares.model;

import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

public class GenericEntityFieldsClass implements Serializable {

    private static final long serialVersionUID = 5113446282997954022L;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "DAT_UPDATE")
    @Type(type = "utcType")
    private Date timestampUpdate;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "DAT_CREATE", columnDefinition = "TIMESTAMP DEFAULT now()", insertable = false, updatable = false, nullable = false)
    @Type(type = "utcType")
    private Date timestampCreate;

    public Date getTimestampUpdate() {
        return timestampUpdate;
    }

    public void setTimestampUpdate(Date timestampUpdate) {
        this.timestampUpdate = timestampUpdate;
    }

    public Date getTimestampCreate() {
        return timestampCreate;
    }

    public void setTimestampCreate(Date timestampCreate) {
        this.timestampCreate = timestampCreate;
    }

    @PrePersist
    public void onCreate() {
        timestampUpdate = timestampCreate = new Date(System.currentTimeMillis());
    }

    @PreUpdate
    public void onUpdate() {
        setTimestampUpdate(new Date(System.currentTimeMillis()));
    }
}
