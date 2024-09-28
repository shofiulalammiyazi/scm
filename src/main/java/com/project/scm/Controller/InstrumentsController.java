package com.project.scm.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.project.scm.model.InstrumentsModel;
import com.project.scm.service.InstrumentsService;

@Controller
@RequestMapping("/instruments")
public class InstrumentsController {

	
	@Autowired
	private  InstrumentsService instrumentsService;
	
	@GetMapping("/manage")
	public String list(Model model) {
		InstrumentsModel instrumentsModel = new InstrumentsModel();
		List<InstrumentsModel> instrumentsModelList = instrumentsService.getAll();
		model.addAttribute("instrumentsModel", instrumentsModel);
		model.addAttribute("instrumentsModelList", instrumentsModelList);
		return "instruments/manage";
	}
	
	@PostMapping("/save")
	public String save(InstrumentsModel instrumentsModel) {
		instrumentsService.save(instrumentsModel);
		return "redirect:/instruments/manage";
	}
}
