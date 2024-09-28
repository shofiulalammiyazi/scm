package com.project.scm.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.scm.model.DemoModel;
import com.project.scm.repository.DemoRepository;


@Service
public class DemoService {

	@Autowired
	private  DemoRepository demoRepository;
	
	public DemoModel save(DemoModel demoModel) {
		demoRepository.save(demoModel);
		return demoModel;
	}
	
	public List<DemoModel> getAll() {
		List<DemoModel> demoList = demoRepository.findAll();
		return demoList;
	}
	
	public DemoModel getById(Long id) {
		DemoModel model = demoRepository.getReferenceById(id);
		return  model;
	}
}
