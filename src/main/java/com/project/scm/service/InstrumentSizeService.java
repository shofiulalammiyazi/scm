package com.project.scm.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.scm.model.InstrumentSizeModel;
import com.project.scm.repository.InstrumentSizeRepository;

@Service
public class InstrumentSizeService {

	@Autowired
	private  InstrumentSizeRepository instrumentSizeRepository;
	
	
	public InstrumentSizeModel save(InstrumentSizeModel instrumentSizeModel) {
		instrumentSizeRepository.save(instrumentSizeModel);
		return instrumentSizeModel;
	}
	
	public List<InstrumentSizeModel> getAll() {
		List<InstrumentSizeModel> instrumentsSizelList = instrumentSizeRepository.findAll();
		return instrumentsSizelList;
	}
}
