package com.project.scm.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.project.scm.model.DoctorNameModel;
import com.project.scm.service.DoctorNameService;

@Controller
@RequestMapping("/doctorName")
public class DoctorNameController {

	@Autowired
	private  DoctorNameService doctorNameService;
	
	@GetMapping("/manage")
	public String list(Model model) {
		DoctorNameModel doctorNameModel = new DoctorNameModel();
		List<DoctorNameModel> doctorNameModelList = doctorNameService.getAll();
		model.addAttribute("doctorNameModel", doctorNameModel);
		model.addAttribute("doctorNamelList", doctorNameModelList);
		return "doctorName/manage";
	}
	
	@PostMapping("/save")
	public String save(DoctorNameModel doctorNameModel) {
		doctorNameService.save(doctorNameModel);
		return "redirect:/doctorName/manage";
	}
}
