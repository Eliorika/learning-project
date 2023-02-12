package com.epam.datalayer.data;

public class Contract {
	private int id;
	private String date;
	private float insuranceAmount;
	private float tariffRate;
	private Branch branch;
	private Insurance insurance;
	
	public int getId() {
		return id;
	}
	public void setId(int num) {
		this.id = num;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public float getInsuranceAmount() {
		return insuranceAmount;
	}
	public void setInsuranceAmount(float insuranceAmount) {
		this.insuranceAmount = insuranceAmount;
	}
	public float getTariffRate() {
		return tariffRate;
	}
	public void setTariffRate(float tariffRate) {
		this.tariffRate = tariffRate;
	}
	public Branch getBranch() {
		return branch;
	}
	public void setBranch(Branch branchId) {
		this.branch = branchId;
	}
	public Insurance getInsurance() {
		return insurance;
	}
	public void setInsurance(Insurance insuranceId) {
		this.insurance = insuranceId;
	}

}
