package com.project.scm.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.scm.model.DoctorNameModel;
import com.project.scm.repository.DoctorNameRepository;

@Service
public class DoctorNameService {

	@Autowired
	private  DoctorNameRepository doctorNameRepository;
	
	
	public DoctorNameModel save(DoctorNameModel doctorNameModel) {
		doctorNameRepository.save(doctorNameModel);
		return doctorNameModel;
	}
	
	public List<DoctorNameModel> getAll() {
		List<DoctorNameModel> doctorNameModelList = doctorNameRepository.findAll();
		return doctorNameModelList;
	}
}
