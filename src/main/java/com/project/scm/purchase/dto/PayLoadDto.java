package com.project.scm.purchase.dto;

import java.util.List;

public class PayLoadDto {
	
	
	private String name;

	private String address;

	private String date;

	private SupplierDataDto supplierDataDto;

	private List<PurchaseDto> purchaseDtoData;

	public SupplierDataDto getSupplierDataDto() {
		return supplierDataDto;
	}

	public void setSupplierDataDto(SupplierDataDto supplierDataDto) {
		this.supplierDataDto = supplierDataDto;
	}

	public List<PurchaseDto> getPurchaseDtoData() {
		return purchaseDtoData;
	}

	public void setPurchaseDtoData(List<PurchaseDto> purchaseDtoData) {
		this.purchaseDtoData = purchaseDtoData;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}
	
	

}
