package com.project.scm.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.project.scm.model.ImplantsModel;
import com.project.scm.service.ImplantsService;

@Controller
@RequestMapping("/implants")
public class ImplantsController {

		
	@Autowired
	private  ImplantsService implantsService;
	
	@GetMapping("/manage")
	public String list(Model model) {
		ImplantsModel implantsModel = new ImplantsModel();
		List<ImplantsModel> implantsModelList = implantsService.getAll();
		model.addAttribute("implantsModel", implantsModel);
		model.addAttribute("implantsModelList", implantsModelList);
		return "implants/manage";
	}
	
	@PostMapping("/save")
	public String save(ImplantsModel implantsModel) {
		implantsService.save(implantsModel);
		return "redirect:/implants/manage";
	}
	
	
}
