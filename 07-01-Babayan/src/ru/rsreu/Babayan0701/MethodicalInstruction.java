package ru.rsreu.Babayan0701;


public class MethodicalInstruction implements Comparable<MethodicalInstruction> {

	private Integer number;
	private String author;
	private Discipline discipline;

	public MethodicalInstruction(int number, String author, Discipline discipline) {
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

	public boolean equals(MethodicalInstruction sample) {
		return this.number == sample.number;
	}

	@Override
	public int hashCode() {
		return this.number;
	}

	@Override
	public int compareTo(MethodicalInstruction sample) {
		return this.number.compareTo(sample.number);
	}

}
