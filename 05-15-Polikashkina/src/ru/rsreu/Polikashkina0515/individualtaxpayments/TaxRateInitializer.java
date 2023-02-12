package ru.rsreu.Polikashkina0515.individualtaxpayments;

public class TaxRateInitializer {
	private TaxType type;
	private float rate;
	private int id;
	
	public TaxRateInitializer(float rate, TaxType type, int id) {
		this.rate = rate;
		this.type = type;
		this.id = id;
	}

	public TaxType getType() {
		return type;
	}

	public float getRate() {
		return rate;
	}

	public Integer getId() {
		return id;
	}
}
