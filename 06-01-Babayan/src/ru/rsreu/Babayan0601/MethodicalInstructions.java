package ru.rsreu.Babayan0601;

import java.io.Serializable;

import com.prutzkow.resourcer.ProjectResourcer;
import com.prutzkow.resourcer.Resourcer;

public class MethodicalInstructions implements Serializable {

	private static final long serialVersionUID = 1L;
	private Integer number;
	private String author;
	private Discipline discipline;

	public MethodicalInstructions(int number, String author, Discipline discipline) {
		this.author = author;
		this.number = number;
		this.discipline = discipline;
	}

	public Integer getNumber() {
		return number;
	}

	public String getAuthor() {
		return author;
	}

	public Discipline getDiscipline() {
		return discipline;
	}

	@Override
	public String toString() {
		StringBuilder result = new StringBuilder();
		result.append(String.format("%-8d", this.number));
		result.append(String.format("%-11s", this.author));
		result.append(String.format("%-11s", this.discipline));
		return result.toString();
	}

	public boolean equals(MethodicalInstructions sample) {
		return this.number == sample.number;
	}

	@Override
	public int hashCode() {
		return this.number;
	}

	public Integer compareTo(MethodicalInstructions sample) {
		return this.number.compareTo(sample.number);
	}

	public static String compareTwoArrays(MethodicalInstructions[] array1, MethodicalInstructions[] array2) {
		Resourcer resourcer = ProjectResourcer.getInstance();
		if (array1.length != array2.length) {
			return resourcer.getString("message.notEqual");
		} else {
			for (int i = 0; i < array2.length; i++) {
				if (array1[i].compareTo(array2[i]) != 0) {
					return resourcer.getString("message.notEqual");
				}
			}
		}

		return resourcer.getString("message.equal");
	}
}
