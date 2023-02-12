package ru.rsreu.Babayan0501.Flowers;

import com.prutzkow.resourcer.ProjectResourcer;
import com.prutzkow.resourcer.Resourcer;

import ru.rsreu.Babayan0501.ColourInformationKeeper;

public class SunflowerFibonacciSumCounter extends AbstractFlower {

	public SunflowerFibonacciSumCounter(ColourInformationKeeper colour, int days, float basicCost)
			throws IllegalArgumentException {
		super(colour, days, basicCost, determineType());
	}

	private static String determineType() {
		Resourcer resourcer = ProjectResourcer.getInstance();
		return resourcer.getString("message.lily");
	}

	public int[] fibonacciNumbersCounter(int amountofNumbers) {
		int[] fibonacciNumbersArray = new int[amountofNumbers];
		fibonacciNumbersArray[0] = 1;
		fibonacciNumbersArray[1] = 1;
		for (int i = 2; i < fibonacciNumbersArray.length; ++i) {
			fibonacciNumbersArray[i] = fibonacciNumbersArray[i - 1] + fibonacciNumbersArray[i - 2];
		}
		return fibonacciNumbersArray;
	}
	
	@Override
	public float countCost(float basicCost, float freshnessLevel, ColourInformationKeeper colour) {
		return (float) (basicCost + freshnessLevel * basicCost + colour.getExtraCharge()) / 2;
	}
}
