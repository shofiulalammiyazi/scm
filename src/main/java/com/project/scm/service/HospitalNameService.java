package com.project.scm.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.scm.model.HospitalNameModel;
import com.project.scm.repository.HospitalNameRepository;

@Service
public class HospitalNameService {

	@Autowired
	private  HospitalNameRepository hospitalNameRepository;
	
	
	public HospitalNameModel save(HospitalNameModel hospitalNameModel) {
		hospitalNameRepository.save(hospitalNameModel);
		return hospitalNameModel;
	}
	
	public List<HospitalNameModel> getAll() {
		List<HospitalNameModel> hospitalNameModelList = hospitalNameRepository.findAll();
		return hospitalNameModelList;
	}
}
