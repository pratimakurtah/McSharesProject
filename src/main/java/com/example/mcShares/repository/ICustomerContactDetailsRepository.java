package com.example.mcShares.repository;

import com.example.mcShares.model.CustomerContactDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface ICustomerContactDetailsRepository extends JpaRepository<CustomerContactDetails, UUID> {

    @Query(value = "SELECT cd FROM CustomerContactDetails cd WHERE LOWER(cd.contactName) LIKE %?1%")
    List<CustomerContactDetails> findByContactName(String contactName);

}
