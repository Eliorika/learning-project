package ru.rsreu.Babayan0701;



import com.prutzkow.resourcer.ProjectResourcer;
import com.prutzkow.resourcer.Resourcer;

public class VariablesInitializer {
	private static MethodicalInstructionsListProcessor methodicalInstructionsList;

	private VariablesInitializer() {
	}

	public static void initialize() {
		Resourcer resourcer = ProjectResourcer.getInstance();

		MethodicalInstruction[] methodicalInstructionsArray = new MethodicalInstruction[4];
		methodicalInstructionsArray[0] = new MethodicalInstruction(1, resourcer.getString("message.ivanov"),
				Discipline.PHYSICS);
		methodicalInstructionsArray[1] = new MethodicalInstruction(2, resourcer.getString("message.petrov"),
				Discipline.PHYSICS);
		methodicalInstructionsArray[2] = new MethodicalInstruction(3, resourcer.getString("message.dubov"),
				Discipline.CHEMISTRY);
		methodicalInstructionsArray[3] = new MethodicalInstruction(4, resourcer.getString("message.dubov"),
				Discipline.MATHS);
		methodicalInstructionsList = new MethodicalInstructionsListProcessor(methodicalInstructionsArray);
	}

	public static MethodicalInstructionsListProcessor getMethodicalInstructionsList() {
		return methodicalInstructionsList;
	}

}