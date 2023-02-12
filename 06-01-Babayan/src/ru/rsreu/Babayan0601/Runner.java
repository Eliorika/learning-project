package ru.rsreu.Babayan0601;


import com.prutzkow.resourcer.ProjectResourcer;
import com.prutzkow.resourcer.Resourcer;

public class Runner {
	private Runner() {
	}

	public static void main(String[] args) {
		Resourcer resourcer = ProjectResourcer.getInstance();

		VariablesInitializer.initialize();

		FileProcessor.writeToFile(VariablesInitializer.getMethodicalInstructionsArray(),
				VariablesInitializer.getOutput());
		FileProcessor.copyFile(VariablesInitializer.getData(), VariablesInitializer.getDataCopy());
		FileProcessor.moveFile(VariablesInitializer.getData().getAbsolutePath(), VariablesInitializer.getPathMove());
		VariablesInitializer.inputInitializator();

		try {
			MethodicalInstructions[] methodicalInstractionsCopiedArray = FileProcessor
					.readFromFile(VariablesInitializer.getInputCopied());
			System.out.printf("\n%s:\n", resourcer.getString("message.copied"));
			TableDrawer.drawTable(methodicalInstractionsCopiedArray);

			MethodicalInstructions[] methodicalInstractionsMovedArray = FileProcessor
					.readFromFile(VariablesInitializer.getInputMoved());
			System.out.printf("\n%s:\n", resourcer.getString("message.moved"));
			TableDrawer.drawTable(methodicalInstractionsMovedArray);
			System.out.printf("\n%s", MethodicalInstructions.compareTwoArrays(methodicalInstractionsCopiedArray,
					methodicalInstractionsMovedArray));
		} catch (Exception e) {
			System.out.println(resourcer.getString("message.notMoved"));
			return;
		}

	}

}
