package ru.rsreu.Babayan0401;

import com.prutzkow.resourcer.ProjectResourcer;
import com.prutzkow.resourcer.Resourcer;

public class Runner {
	/**
	 * Constant LEFT_BORDER stores a minimal value to generate an array's element.
	 */
	public static final int LEFT_BORDER = 0;
	
	/**
	 * Constant RIGHT_BORDER stores a maximal value to generate an array's element.
	 */
	public static final int RIGHT_BORDER = 100;
	
	/**
	 * Constant MATRIX_SIZE stores the size of a matrix.
	 */
	public static final int MATRIX_SIZE = 5;
	
	/**
	 * Runner() is a private constructor.
	 */
	private Runner() {
	}
	
	/**
	 * Method main starts a programm's execution. It contains methods to complete the task.
	 * The task is: "Replace elements' of the main diagonal with a sum of elements in a column."
	 */
	public static void main(String[] args) {
		Resourcer resourcer = ProjectResourcer.getInstance();
		
		ElementsOfTheMainDiagonalOfSquareMatrixReplacer squarMatrix = new ElementsOfTheMainDiagonalOfSquareMatrixReplacer(MATRIX_SIZE, MATRIX_SIZE);
		squarMatrix.fill(RIGHT_BORDER, LEFT_BORDER);
		
		StringBuilder result = new StringBuilder();
		result.append(resourcer.getString("message.originalArray")).append("\n").append(squarMatrix.toString()).append("\n");
		squarMatrix.replaceElementsOfTheMainDiadonalWithSumOfColumsElements();
		result.append("\n").append(resourcer.getString("message.result")).append("\n").append(squarMatrix.toString());
		System.out.println(result);
	}

}
