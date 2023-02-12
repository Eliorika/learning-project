package ru.rsreu.Babayan0301;

import java.util.Arrays;

import com.prutzkow.resourcer.ProjectResourcer;
import com.prutzkow.resourcer.Resourcer;

public class ArraysLastEvenAndFirstOddFinder {

	private int[] arrayBody;
	
	public ArraysLastEvenAndFirstOddFinder(int... args) {
		this.arrayBody = new int [args.length];
		setArrayElements(args);
	}

	private void setArrayElements(int... args) {
		for (int i = 0; i < args.length; i++) {
			this.arrayBody[i] = args[i];
		}
	}
	
	public void swapTwoElements(int firstIndex, int secondIndex) {
		int a = this.arrayBody[firstIndex];
		this.arrayBody[firstIndex] = this.arrayBody[secondIndex];
		this.arrayBody[secondIndex] = a;
	}
	
	public int findTheFirstOddIndex() {
		int oddIndex = -1;
		for (int i = 0; i < this.arrayBody.length; i++) {
			if (this.arrayBody[i] % 2 != 0) {
				oddIndex = i;
				break;
			}
		}
		return oddIndex;
	}
	
	public int findTheLastEvenIndex() {
		int evenIndex = -1;
		for (int i = 0; i < this.arrayBody.length; i++) {
			if (this.arrayBody[i] % 2 == 0) {
				evenIndex = i;
			}
		}
		return evenIndex;
	}
	
	@Override
	public String toString() {
		return Arrays.toString(this.arrayBody);
	}
	
	public static String getIndexesInformation(int lastEvenIndex, int firstOddIndex) {
		Resourcer resourcer = ProjectResourcer.getInstance();
		StringBuilder result = new StringBuilder("");
		if (lastEvenIndex == -1) {
			result.append(resourcer.getString("message.noEven")).append("\n");
		} else {
			result.append(resourcer.getString("message.theEvenResult")).append(lastEvenIndex).append("\n");
		}
		
		if (firstOddIndex == -1) {
			result.append(resourcer.getString("message.noOdd")).append("\n");
		} else {
			result.append(resourcer.getString("message.theOddResult")).append(firstOddIndex).append("\n");
		}
		return result.toString();
	}
	
	public void swapMinAndMaxElements() {
		int firstOddIndex = this.findTheFirstOddIndex();
		int lastEvenIndex = this.findTheLastEvenIndex();
		if (lastEvenIndex != -1 && firstOddIndex != -1) {
			this.swapTwoElements(firstOddIndex, lastEvenIndex);
		}
	}
}