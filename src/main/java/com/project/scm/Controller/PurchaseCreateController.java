package com.project.scm.Controller;

import java.security.Principal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.project.scm.Util.DateUtil;
import com.project.scm.model.PurchaseInfoModel;
import com.project.scm.model.SupplierInfoModel;
import com.project.scm.model.SupplierInfoService;
import com.project.scm.purchase.dto.PayLoadDto;
import com.project.scm.purchase.dto.PurchaseDto;
import com.project.scm.purchase.dto.SupplierDataDto;
import com.project.scm.repository.PurchaseInfoRepository;
import com.project.scm.repository.SupplierInfoRepository;

@Controller
public class PurchaseCreateController {
	
	
	@Autowired
	private SupplierInfoRepository supplierInfoRepository;
	
	@Autowired
	private PurchaseInfoRepository purchaseInfoRepository;
	
	@Autowired
	private  SupplierInfoService supplierInfoService;
	
	@GetMapping("/create/purchase")
	public String list(Model model) {
		List<SupplierInfoModel> supplierList = supplierInfoService.getAll();
		model.addAttribute("supplierList", supplierList);
		return "purchase/purchaseCreate";
	}

	/*
	 * @GetMapping(value = "/create/purchase") public ModelAndView getpurcahePage()
	 * { ModelAndView modelAndView = new ModelAndView();
	 * 
	 * modelAndView.setViewName("purchase/purchaseCreate"); return modelAndView;
	 * 
	 * }
	 */

	@ResponseBody
	@PostMapping(value = "scrm2/ticket/inbound")
	public PayLoadDto submitTableData(@RequestBody PayLoadDto PayloadDtoData,Principal principal) {
		try {
			PayLoadDto rspData = new PayLoadDto();
			
			if (PayloadDtoData!=null) {
				SupplierInfoModel supplierInfo=new SupplierInfoModel();
				SimpleDateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");
		        Calendar cal = Calendar.getInstance();
		        Date date = cal.getTime();
		        String todaysdate = dateFormat.format(date);
				
				if(PayloadDtoData.getSupplierDataDto()!=null)
				{
					SupplierDataDto dtoSupplierData=PayloadDtoData.getSupplierDataDto();
					supplierInfo.setSupplierName(dtoSupplierData.getName());
					supplierInfo.setSupplierAddress(dtoSupplierData.getAddress());
					SimpleDateFormat inputFormat = new SimpleDateFormat("yyyy-MM-dd");
			        SimpleDateFormat outputFormat = new SimpleDateFormat("dd/MM/yyyy");
			        try {
			            Date orgDate = inputFormat.parse(dtoSupplierData.getDate());
			            String formattedDate = outputFormat.format(orgDate);
			            supplierInfo.setPurchaseDate(DateUtil.convertStringToDate(formattedDate));
			            System.out.println("Converted Date: " + formattedDate);
			        } catch (ParseException e) {
			            e.printStackTrace();
			        }
					supplierInfo.setIssueDate(DateUtil.convertStringToDate(todaysdate));
					supplierInfo.setMakeBy(principal.getName());
					supplierInfoRepository.save(supplierInfo);
					
				}
				for (PurchaseDto purchaseDto : PayloadDtoData.getPurchaseDtoData()) {
					if(purchaseDto!=null)
					{
						 PurchaseInfoModel purchaseInfo = new PurchaseInfoModel();
	                        purchaseInfo.setProductName(purchaseDto.getProductName());
	                        purchaseInfo.setProductType(purchaseDto.getProductType());
	                        purchaseInfo.setProductSize(purchaseDto.getProductSize());
	                        purchaseInfo.setAmount(Double.parseDouble(purchaseDto.getProductAmount()));
	                        purchaseInfo.setProductQuantity(purchaseDto.getProductQuantity());
	                        purchaseInfo.setPurchaseDate(DateUtil.convertStringToDate(todaysdate));
	                        purchaseInfo.setSupplier(supplierInfo);
	                        purchaseInfo.setMakeBy(principal.getName());
	                        purchaseInfoRepository.save(purchaseInfo);
					}

				}
			}
			return rspData;

		} catch (Exception e) {
			// TODO: handle exception
		}

		return null;
	}

}
