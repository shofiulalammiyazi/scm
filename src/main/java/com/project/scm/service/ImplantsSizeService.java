package com.project.scm.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.scm.model.ImplantsSizeModel;
import com.project.scm.repository.ImplantsSizeRepository;

@Service
public class ImplantsSizeService {

	@Autowired
	private  ImplantsSizeRepository implantsSizeRepository;
	
	
	public ImplantsSizeModel save(ImplantsSizeModel implantsSizeModel) {
		implantsSizeRepository.save(implantsSizeModel);
		return implantsSizeModel;
	}
	
	public List<ImplantsSizeModel> getAll() {
		List<ImplantsSizeModel> implantsSizeList = implantsSizeRepository.findAll();
		return implantsSizeList;
	}
}
