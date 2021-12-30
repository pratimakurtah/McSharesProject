package com.example.mcShares.repository;

import com.example.mcShares.model.CustomerMailingAddress;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface ICustomerMailingDetailsRepository extends JpaRepository<CustomerMailingAddress, UUID> {

}
