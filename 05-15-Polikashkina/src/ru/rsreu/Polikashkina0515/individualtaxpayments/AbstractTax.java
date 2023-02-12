package ru.rsreu.Polikashkina0515.individualtaxpayments;

import com.prutzkow.resourcer.ProjectResourcer;
import com.prutzkow.resourcer.Resourcer;



public abstract class AbstractTax implements Comparable<AbstractTax> {
	
	private TaxRateInitializer tax;
	private float amount;
	
	public AbstractTax(TaxRateInitializer tax, float money) {
		this.tax = tax;
		this.amount = countAmount(tax, money);
	}
	
	public String toString() {
		StringBuilder info = new StringBuilder();
		Resourcer resourcer = ProjectResourcer.getInstance();
		info.append(resourcer.getString("string.out.type")).append(this.tax.getType()).append("\n");
		return info.toString();
	}
	
	@Override
	public int compareTo(AbstractTax tax2) {
		int result = this.tax.getId().compareTo(tax2.tax.getId());
		return result;
	}
	
	public float countAmount(TaxRateInitializer tax, float money) {
		float amount = money * tax.getRate();
		return amount;
	}

	public float getAmount() {
		return amount;
	}
}
