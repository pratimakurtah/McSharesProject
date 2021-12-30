package com.example.mcShares.model;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.io.Serializable;
import java.util.UUID;

@Entity
@Table(name = "T_CUSTOMER_TYPE")
public class CustomerType extends GenericEntityFieldsClass implements Serializable {

    private static final long serialVersionUID = 8265036076938935039L;
    @Id
    @Type(type = "org.hibernate.type.PostgresUUIDType")
    @Column(name = "ID_CUSTOMER_TYPE", columnDefinition = "uuid", updatable = false)
    @GeneratedValue(generator = "uuid2")
    @GenericGenerator(name = "uuid2", strategy = "uuid2")
    private UUID idCustomerType;

    @Column(name = "COD_CUSTOMER_TYPE", length = 50, nullable = false)
    private String codCustomerType;

    @Column(name = "LIB_CUSTOMER_TYPE", length = 50, nullable = false)
    private String libCustomerType;

    public UUID getIdCustomerType() {
        return idCustomerType;
    }

    public void setIdCustomerType(UUID idCustomerType) {
        this.idCustomerType = idCustomerType;
    }

    public String getCodCustomerType() {
        return codCustomerType;
    }

    public void setCodCustomerType(String codCustomerType) {
        this.codCustomerType = codCustomerType;
    }

    public String getLibCustomerType() {
        return libCustomerType;
    }

    public void setLibCustomerType(String libCustomerType) {
        this.libCustomerType = libCustomerType;
    }
}
