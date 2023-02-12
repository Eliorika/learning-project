package ru.rsreu.Babayan0301;

import com.prutzkow.resourcer.ProjectResourcer;
import com.prutzkow.resourcer.Resourcer;

public class Runner {
	public static final int[] ARRAY_OF_INTEGERS = { 2, 3, 75, 5, 63 };

	private Runner() {
	}

	public static void main(String[] args) {

		ArraysLastEvenAndFirstOddFinder oneDimArray = new ArraysLastEvenAndFirstOddFinder(ARRAY_OF_INTEGERS);
		int firstOddIndex = oneDimArray.findTheFirstOddIndex();
		int lastEvenIndex = oneDimArray.findTheLastEvenIndex();
		StringBuilder result = new StringBuilder();

		Resourcer resourcer = ProjectResourcer.getInstance();
		result.append(resourcer.getString("message.originalArray")).append(": ").append(oneDimArray.toString());
		result.append("\n").append(ArraysLastEvenAndFirstOddFinder.getIndexesInformation(lastEvenIndex, firstOddIndex));
		oneDimArray.swapMinAndMaxElements();
		result.append(resourcer.getString("message.theResult")).append(oneDimArray.toString());

		System.out.println(result);
	}

}
