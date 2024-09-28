package com.project.scm.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.project.scm.model.PurchaseInfoModel;

@Repository("purchaseInfoRepository")
public interface PurchaseInfoRepository extends JpaRepository<PurchaseInfoModel, Long> {

}
