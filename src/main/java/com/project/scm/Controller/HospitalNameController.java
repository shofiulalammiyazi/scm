package com.project.scm.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.project.scm.model.HospitalNameModel;
import com.project.scm.service.HospitalNameService;

@Controller
@RequestMapping("/hospitalName")
public class HospitalNameController {

	@Autowired
	private  HospitalNameService hospitalNameService;
	
	@GetMapping("/manage")
	public String list(Model model) {
		HospitalNameModel hospitalNameModel = new HospitalNameModel();
		List<HospitalNameModel> hospitalNameList = hospitalNameService.getAll();
		model.addAttribute("hospitalName", hospitalNameModel);
		model.addAttribute("hospitalNameList", hospitalNameList);
		return "hospitalName/manage";
	}
	
	@PostMapping("/save")
	public String save(HospitalNameModel hospitalNameModel) {
		hospitalNameService.save(hospitalNameModel);
		return "redirect:/hospitalName/manage";
	}
}
