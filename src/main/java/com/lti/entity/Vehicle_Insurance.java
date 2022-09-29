package com.lti.entity;

import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Vehicle_Insurance")
public class Vehicle_Insurance {

	@Id
	private String reg_no;
	
	private String model;
	private String manufacturer;
	private Long purchase_price;
	private Date purchase_date;
	private String chasis_no;
	private String engine_no;
	private String license_no;
	
	public String getReg_no() {
		return reg_no;
	}
	public void setReg_no(String reg_no) {
		this.reg_no = reg_no;
	}
	public String getModel() {
		return model;
	}
	public void setModel(String model) {
		this.model = model;
	}
	public String getManufacturer() {
		return manufacturer;
	}
	public void setManufacturer(String manufacturer) {
		this.manufacturer = manufacturer;
	}
	public Date getPurchase_date() {
		return purchase_date;
	}
	public void setPurchase_date(String purchase_date) {
		this.purchase_date = Date.valueOf(purchase_date);
	}
	public String getChasis_no() {
		return chasis_no;
	}
	public void setChasis_no(String chasis_no) {
		this.chasis_no = chasis_no;
	}
	public String getEngine_no() {
		return engine_no;
	}
	public void setEngine_no(String engine_no) {
		this.engine_no = engine_no;
	}
	public String getLicense_no() {
		return license_no;
	}
	public void setLicense_no(String license_no) {
		this.license_no = license_no;
	}
	public Long getPurchase_price() {
		return purchase_price;
	}
	public void setPurchase_price(Long purchase_price) {
		this.purchase_price = purchase_price;
	}
	@Override
	public String toString() {
		return "Vehicle_Insurance [reg_no=" + reg_no + ", model=" + model + ", manufacturer=" + manufacturer
				+ ", purchase_price=" + purchase_price + ", purchase_date=" + purchase_date + ", chasis_no=" + chasis_no
				+ ", engine_no=" + engine_no + ", license_no=" + license_no + "]";
	}
	

	
	
}
