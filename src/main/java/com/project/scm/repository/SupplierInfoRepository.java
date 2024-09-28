package com.project.scm.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.project.scm.model.SupplierInfoModel;
import java.util.List;


@Repository
public interface SupplierInfoRepository extends JpaRepository<SupplierInfoModel, Long>{
	
	//List<SupplierInfoModel> findBySupplierName(String supplierName);

}
