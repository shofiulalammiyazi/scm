package com.project.scm.model;

import java.util.Date;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "tbl_supplier_info")
public class SupplierInfoModel {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "supplier_name")
	private String supplierName;

	@Column(name = "supplier_address")
	private String supplierAddress;

	@Column(name = "number")
	private String number;
	

	@Column(name = "issue_date")
	private Date issueDate;

	@Column(name = "purchase_date")
	private Date purchaseDate;

	@Column(name = "makeBy")
	private String makeBy;

	// One-to-Many relationship with PurchaseInfoModel
	@OneToMany(mappedBy = "supplier", cascade = CascadeType.ALL, orphanRemoval = true)
	private List<PurchaseInfoModel> purchases;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getSupplierName() {
		return supplierName;
	}

	public void setSupplierName(String supplierName) {
		this.supplierName = supplierName;
	}

	public String getSupplierAddress() {
		return supplierAddress;
	}

	public void setSupplierAddress(String supplierAddress) {
		this.supplierAddress = supplierAddress;
	}

	public Date getIssueDate() {
		return issueDate;
	}

	public void setIssueDate(Date issueDate) {
		this.issueDate = issueDate;
	}

	public Date getPurchaseDate() {
		return purchaseDate;
	}

	public void setPurchaseDate(Date purchaseDate) {
		this.purchaseDate = purchaseDate;
	}

	public String getMakeBy() {
		return makeBy;
	}

	public void setMakeBy(String makeBy) {
		this.makeBy = makeBy;
	}

	public List<PurchaseInfoModel> getPurchases() {
		return purchases;
	}

	public void setPurchases(List<PurchaseInfoModel> purchases) {
		this.purchases = purchases;
	}
	
	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}
	

}
