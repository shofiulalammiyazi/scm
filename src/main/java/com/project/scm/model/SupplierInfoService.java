package com.project.scm.model;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.scm.repository.SupplierInfoRepository;

@Service
public class SupplierInfoService {

	
	@Autowired
	private  SupplierInfoRepository supplierInfoRepository;
	
	
	public SupplierInfoModel save(SupplierInfoModel supplierInfoModel) {
		supplierInfoRepository.save(supplierInfoModel);
		return supplierInfoModel;
	}
	
	public List<SupplierInfoModel> getAll() {
		List<SupplierInfoModel> supplierInfoModel = supplierInfoRepository.findAll();
		return supplierInfoModel;
	}
	
	/*
	 * public List<SupplierInfoModel> supplierName(SupplierInfoModel
	 * supplierInfoModel){
	 * supplierInfoRepository.findBySupplierName(supplierInfoModel) return
	 * supplierInfoModel; }
	 */
}
