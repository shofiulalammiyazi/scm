package com.project.scm.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.project.scm.model.SupplierInfoModel;
import com.project.scm.model.SupplierInfoService;


@Controller
@RequestMapping("/supplier")
public class SupplierController {
	
	@Autowired
	private  SupplierInfoService supplierInfoService;
	
	@GetMapping("/manage")
	public String list(Model model) {
		SupplierInfoModel supplierInfoModel = new SupplierInfoModel();
		List<SupplierInfoModel> supplierList = supplierInfoService.getAll();
		model.addAttribute("supplierList", supplierList);
		model.addAttribute("supplierModel", supplierInfoModel);
		return "supplier/manage";
	}
	
	@PostMapping("/save")
	public String save(SupplierInfoModel supplierInfoModel) {
		supplierInfoService.save(supplierInfoModel);
		return "redirect:/supplier/manage";
	}

}
