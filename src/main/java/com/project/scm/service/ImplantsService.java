package com.project.scm.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.scm.model.ImplantsModel;
import com.project.scm.repository.ImplantsRepository;

@Service
public class ImplantsService {

	@Autowired
	private  ImplantsRepository implantsRepository;
	
	
	public ImplantsModel save(ImplantsModel implantsModel) {
		implantsRepository.save(implantsModel);
		return implantsModel;
	}
	
	public List<ImplantsModel> getAll() {
		List<ImplantsModel> implantsModelList = implantsRepository.findAll();
		return implantsModelList;
	}
}
