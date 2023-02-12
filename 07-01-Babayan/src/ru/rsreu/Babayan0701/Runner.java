package ru.rsreu.Babayan0701;

import com.prutzkow.resourcer.ProjectResourcer;
import com.prutzkow.resourcer.Resourcer;

public class Runner {
	
	public static final int NUMBER_TO_FIND = 4;
	public static final int NUMBER_NOT_TO_FIND = 10;
	private Runner() {
	}

	public static void main(String[] args) {
		Resourcer resourcer = ProjectResourcer.getInstance();
		StringBuilder result = new StringBuilder();
		VariablesInitializer.initialize();

		result.append(resourcer.getString("message.sortByAuthorDiscipline")).append("\n");
		MethodicalInstructionsListProcessor
				.sortByNameAndDiscipline(VariablesInitializer.getMethodicalInstructionsList());
		result.append(TableDrawer.drawTable(VariablesInitializer.getMethodicalInstructionsList()));

		result.append(resourcer.getString("message.sortByDefault")).append("\n");
		MethodicalInstructionsListProcessor.sortByDefault(VariablesInitializer.getMethodicalInstructionsList());
		result.append(TableDrawer.drawTable(VariablesInitializer.getMethodicalInstructionsList()));

		result.append(resourcer.getString("message.allAuthors")).append("\n");
		result.append(VariablesInitializer.getMethodicalInstructionsList().getAllAuthors()).append("\n");

		result.append(resourcer.getString("message.find")).append(NUMBER_TO_FIND).append("\n");
		result.append(VariablesInitializer.getMethodicalInstructionsList().findMethodicalInstruction(NUMBER_TO_FIND));

		result.append("\n").append(resourcer.getString("message.find")).append(NUMBER_NOT_TO_FIND).append("\n");
		result.append(VariablesInitializer.getMethodicalInstructionsList().findMethodicalInstruction(NUMBER_NOT_TO_FIND));

		result.append("\n").append(resourcer.getString("message.afterDelete")).append(Discipline.PHYSICS).append("\n");
		VariablesInitializer.getMethodicalInstructionsList()
				.deleteMethodicalInstructionOfDescipline(Discipline.PHYSICS);
		result.append(TableDrawer.drawTable(VariablesInitializer.getMethodicalInstructionsList()));

		System.out.println(result);
	}

}
