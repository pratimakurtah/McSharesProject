package com.example.mcShares.repository;

import com.example.mcShares.dto.CustomerSharesDetailsDTO;
import com.example.mcShares.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.UUID;

public interface ICustomerRepository extends JpaRepository<Customer, UUID> {

    @Query(value = "SELECT DISTINCT c FROM Customer c WHERE c.refCustomer = ?1")
    Customer findByRefCustomer(String refCustomer);

    @Query(value = "SELECT c FROM Customer c WHERE LOWER(c.customerContactDetails.contactName) LIKE %?1%")
    List<Customer> findAllByCustomerContactDetails_ContactName(String contactName);

    @Query(value = "SELECT new com.example.mcShares.dto.CustomerSharesDetailsDTO(c.refCustomer, c.customerContactDetails.contactName, c.dateOfBirth, c.customerType.libCustomerType, c.customerSharesDetails.numShares, c.customerSharesDetails.sharePrice, (c.customerSharesDetails.numShares * c.customerSharesDetails.sharePrice)) FROM Customer c")
    List<CustomerSharesDetailsDTO> retrieveCustomerDetailsAsDTO();

}
