package ru.rsreu.Babayan0701;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collectors;

import com.prutzkow.resourcer.ProjectResourcer;
import com.prutzkow.resourcer.Resourcer;

public class MethodicalInstructionsListProcessor {
	private List<MethodicalInstruction> methodicalInstractionsList;

	public MethodicalInstructionsListProcessor(MethodicalInstruction... args) {
		this.methodicalInstractionsList = new ArrayList<MethodicalInstruction>();
		createList(args);
	}

	private void createList(MethodicalInstruction... args) {
		for (int i = 0; i < args.length; i++) {
			this.methodicalInstractionsList.add(args[i]);
		}
	}

	public static void sortByNameAndDiscipline(MethodicalInstructionsListProcessor list) {
		Comparator<MethodicalInstruction> nameAndDiscipline = new NameAndDisciplineComporator();
		Collections.sort(list.methodicalInstractionsList, nameAndDiscipline);
	}

	public static void sortByDefault(MethodicalInstructionsListProcessor list) {
		Collections.sort(list.methodicalInstractionsList);
	}

	@Override
	public String toString() {
		StringBuilder result = new StringBuilder();
		Iterator<MethodicalInstruction> iterator = this.methodicalInstractionsList.iterator();
		while (iterator.hasNext()) {
			MethodicalInstruction current = iterator.next();
			result.append(current.toString()).append("\n");
		}
		return result.toString();
	}

	private Set<String> getSetOfAuthors() {
		Set<String> setOfAuthors = new HashSet<String>();
		Iterator<MethodicalInstruction> iterator = this.methodicalInstractionsList.iterator();
		while (iterator.hasNext()) {
			MethodicalInstruction current = iterator.next();
			setOfAuthors.add(current.getAuthor());
		}
		return setOfAuthors;
	}

	private String setToString(Set<String> set) {
		StringBuilder result = new StringBuilder();
		Iterator<String> iterator = set.iterator();
		while (iterator.hasNext()) {
			String current = iterator.next();
			result.append(current).append("\n");
		}
		return result.toString();
	}

	public String getAllAuthors() {
		Set<String> setOfAuthors = getSetOfAuthors();
		return setToString(setOfAuthors);
	}

	public void deleteMethodicalInstructionOfDescipline(Discipline discipline) {
		Iterator<MethodicalInstruction> iterator = this.methodicalInstractionsList.iterator();
		while (iterator.hasNext()) {
			MethodicalInstruction current = iterator.next();
			if (discipline.equals(current.getDiscipline())) {
				iterator.remove();
			}
		}
	}

	private boolean isMethodicalInstructionInList(int number) {
		Map<Integer, MethodicalInstruction> map = this.methodicalInstractionsList.stream()
				.collect(Collectors.toMap(MethodicalInstruction::getNumber, Function.identity()));
		return map.containsKey(number);
	}

	public String findMethodicalInstruction(int number) {
		Resourcer resourcer = ProjectResourcer.getInstance();
		StringBuilder result = new StringBuilder();

		if (isMethodicalInstructionInList(number)) {
			sortByDefault(this);
			result.append(TableDrawer.drawTable(this.methodicalInstractionsList.get(number - 1)));
		} else {
			result.append(resourcer.getString("message.notFound"));
		}

		return result.toString();
	}
}