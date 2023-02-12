package com.epam.datalayer;

import java.util.List;
import java.util.Map;

import com.epam.datalayer.data.Contract;

public abstract class DAOFactory {
	public static DAOFactory getInstance(DBType dbType) {
		DAOFactory result = dbType.getDAOFactory();
		return result;
	}

	public abstract List<Contract> findInformationAboutConractsBetweenDates(String date1, String date2);
	public abstract List<String> findBranchesAndInsurances();
	public abstract Map<String, Float> findAvarageSum();
	public abstract String resultOfStatesmans(String date1, String date2);

}
