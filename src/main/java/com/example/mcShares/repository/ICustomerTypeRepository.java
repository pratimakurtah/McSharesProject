package com.example.mcShares.repository;

import com.example.mcShares.model.CustomerType;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface ICustomerTypeRepository extends JpaRepository<CustomerType, UUID> {

    @Query(value = "SELECT ct FROM CustomerType ct WHERE ct.libCustomerType = ?1")
    CustomerType findByLibCustomerType(String libCustomerType);

}
