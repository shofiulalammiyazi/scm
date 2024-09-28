package com.project.scm.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.project.scm.model.ImplantsSizeModel;
import com.project.scm.service.ImplantsSizeService;

@Controller
@RequestMapping("/implantsSize")
public class ImplantsSizeController {

	
	@Autowired
	private  ImplantsSizeService implantsSizeService;
	
	@GetMapping("/manage")
	public String list(Model model) {
		ImplantsSizeModel implantsSizeModel = new ImplantsSizeModel();
		List<ImplantsSizeModel> implantsSizeList = implantsSizeService.getAll();
		model.addAttribute("implantsSizeModel", implantsSizeModel);
		model.addAttribute("implantsSizeList", implantsSizeList);
		return "implantsSize/manage";
	}
	
	@PostMapping("/save")
	public String save(ImplantsSizeModel implantsSizeModel) {
		implantsSizeService.save(implantsSizeModel);
		return "redirect:/implantsSize/manage";
	}
}
