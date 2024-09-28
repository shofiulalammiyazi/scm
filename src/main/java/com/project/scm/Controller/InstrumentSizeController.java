package com.project.scm.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.project.scm.model.InstrumentSizeModel;
import com.project.scm.service.InstrumentSizeService;

@Controller
@RequestMapping("/instrumentsSize")
public class InstrumentSizeController {

	@Autowired
	private  InstrumentSizeService instrumentSizeService;
	
	@GetMapping("/manage")
	public String list(Model model) {
		InstrumentSizeModel instrumentSizeModel = new InstrumentSizeModel();
		List<InstrumentSizeModel> instrumentSizeModelList = instrumentSizeService.getAll();
		model.addAttribute("instrumentSizeModel", instrumentSizeModel);
		model.addAttribute("instrumentSizeModelList", instrumentSizeModelList);
		return "instrumentSize/manage";
	}
	
	@PostMapping("/save")
	public String save(InstrumentSizeModel instrumentSizeModel) {
		instrumentSizeService.save(instrumentSizeModel);
		return "redirect:/instrumentsSize/manage";
	}
	
}
