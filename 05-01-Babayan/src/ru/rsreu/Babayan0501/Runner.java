package ru.rsreu.Babayan0501;

import com.prutzkow.resourcer.ProjectResourcer;
import com.prutzkow.resourcer.Resourcer;

public class Runner {

	private Runner() {
	}

	public static void main(String[] args) {

		Resourcer resourcer = ProjectResourcer.getInstance();
		VariablesInitialisator.initializeAllVariables();
		StringBuilder result = new StringBuilder();

		result.append(resourcer.getString("message.originalBouquet")).append("\n")
				.append(VariablesInitialisator.getBoquet().toString()).append("\n");

		result.append("\n").append(VariablesInitialisator.getChamomileWhite().toString());
		result.append(VariablesInitialisator.getBoquet()
				.getInfromationAboutFlowerPresence(VariablesInitialisator.getChamomileWhite()));
		result.append("\n").append(VariablesInitialisator.getChamomileViolet().toString());
		result.append(VariablesInitialisator.getBoquet()
				.getInfromationAboutFlowerPresence(VariablesInitialisator.getChamomileViolet()));

		System.out.println(result);

	}

}
