package ru.rsreu.Polikashkina0515.individualtaxpayments;

import java.util.Scanner;

public class IndividualTaxPayments extends AbstractTax {
	private double taxBase;
	
	public IndividualTaxPayments (TaxRateInitializer tax, int id, float money, float deductionAmount) {
		super(tax, money);
		this.taxBase = money * tax.getRate() - deductionAmount;
	}
	
	public double getTaxBase() {
		return this.taxBase;
	}
	
	@Override
	public float countAmount(TaxRateInitializer tax, float money) {
		float amount = (float) (money * tax.getRate() -  this.taxBase);
		return amount;
	}
}
