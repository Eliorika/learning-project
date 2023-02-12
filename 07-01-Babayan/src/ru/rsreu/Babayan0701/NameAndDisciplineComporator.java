package ru.rsreu.Babayan0701;

import java.util.Comparator;

public class NameAndDisciplineComporator implements Comparator<MethodicalInstruction> {
	
	public NameAndDisciplineComporator() {
		
	}
	
	@Override
	public int compare(MethodicalInstruction o1, MethodicalInstruction o2) {
		int result = -1; 
		if (o1.getAuthor().compareTo(o2.getAuthor()) > 0) {
			result = 1;
		} else if (o1.getAuthor().equals(o2.getAuthor())) {
			if (o1.getDiscipline().equals(o2.getDiscipline())) {
				result = 0;
			} else if (o1.getDiscipline().compareTo(o2.getDiscipline()) < 0) {
				result = 1;
			}
		}
		return result;
	}
}
