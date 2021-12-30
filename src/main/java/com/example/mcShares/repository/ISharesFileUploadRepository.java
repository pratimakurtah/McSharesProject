package com.example.mcShares.repository;

import com.example.mcShares.model.SharesFileUpload;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface ISharesFileUploadRepository extends JpaRepository<SharesFileUpload, UUID> {

}
