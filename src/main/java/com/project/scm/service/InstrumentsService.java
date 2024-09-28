package com.project.scm.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.scm.model.InstrumentsModel;
import com.project.scm.repository.InstrumentsRepository;

@Service
public class InstrumentsService {

	@Autowired
	private  InstrumentsRepository instrumentsRepository;
	
	
	public InstrumentsModel save(InstrumentsModel instrumentsModel) {
		instrumentsRepository.save(instrumentsModel);
		return instrumentsModel;
	}
	
	public List<InstrumentsModel> getAll() {
		List<InstrumentsModel> instrumentsModelList = instrumentsRepository.findAll();
		return instrumentsModelList;
	}
}
