package ru.rsreu.Babayan0401;

import com.prutzkow.resourcer.ProjectResourcer;
import com.prutzkow.resourcer.Resourcer;
import com.prutzkow.twodimarray.Matrix;

public class ElementsOfTheMainDiagonalOfSquareMatrixReplacer extends Matrix {
	
	/**
	 * ElementsOfTheMainDiagonalOfSquareMatrixReplacer is a constructor.
	 * @param sizeX number of rows
	 * @param sizeY number of columns
	 */
	public ElementsOfTheMainDiagonalOfSquareMatrixReplacer(int sizeX, int sizeY) throws IllegalArgumentException {
		super(sizeX, sizeY);
	}
	
	/**
	 * Method sumUpColumnElements finds the sum of all elements in a column.
	 * @param columnNumber number of a column
	 */
	private int sumUpColumnElements(int columnNumber) {
		int sum = 0;
		for (int i = 0; i < super.getColCount(); i++) {
			sum += this.arrayBody[i][columnNumber];
		}
		return sum;
	}
	
	/**
	 * Method replaceElementsOfTheMainDiadonalWithSumOfColumsElementss perform task.
	 * The task is: "Replace elements' of the main diagonal with a sum of elements in a column."
	 */
	public void replaceElementsOfTheMainDiadonalWithSumOfColumsElements() {
		for (int i = 0; i < super.getColCount(); i++) {
			int sum = sumUpColumnElements(i);
			this.arrayBody[i][i] = sum;
		}
	}
	
	/**
	 * Method fill fills the matrix with random values generated in a gap.
	 * @param leftBorder left border of a gap
	 * @param rightBorder right border of a gap
	 */
	public void fill(int leftBorder, int rightBorder) {
		for (int i = 0; i < super.getColCount(); i++) {
			for (int j = 0; j < super.getColCount(); j++) {
				int randInt = (int) (Math.random() * (rightBorder - leftBorder)) + leftBorder;
				this.arrayBody[i][j] = randInt;
			}
		}
	}

	/**
	 * Method getElementsCount finds the count of elements in a matrix
	 */
	private int getElementsCount() {
		return super.getColCount() * super.getRowCount();
	}
	
	/**
	 * Method toString converts an array into String. It's an overridden method.
	 */
	@Override
	public String toString() {
		StringBuilder result = new StringBuilder(super.toString());
		Resourcer resourcer = ProjectResourcer.getInstance();
		result.append(resourcer.getString("message.elementsCount")).append(this.getElementsCount());
		return result.toString();
	}
}
