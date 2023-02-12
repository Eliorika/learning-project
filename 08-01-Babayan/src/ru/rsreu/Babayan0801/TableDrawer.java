package ru.rsreu.Babayan0801;

import java.util.Iterator;
import java.util.List;
import java.util.Map;

import com.epam.datalayer.data.Contract;
import com.prutzkow.resourcer.ProjectResourcer;
import com.prutzkow.resourcer.Resourcer;

public class TableDrawer {
	private TableDrawer() {

	}

	public static String drawContractList(List<Contract> list) {
		StringBuilder result = new StringBuilder();
		Resourcer resourcer = ProjectResourcer.getInstance();
		result.append(String.format("|%1$-11s|%2$-18s|%3$-16s|%4$-11s|%5$-11s|%6$-20s|\n", resourcer.getString("contract.id"),
				resourcer.getString("table.contract.date"), resourcer.getString("table.contract.amount"),
				resourcer.getString("table.contract.tariff"), resourcer.getString("table.branch.name"),
				resourcer.getString("table.insurance.name")));
		for (Iterator<Contract> iterator = list.iterator(); iterator.hasNext();) {
			Contract contract = iterator.next();
			result.append(String.format("|%1$-11s|%2$-18s|%3$-16s|%4$-11s|%5$-11s|%6$-20s|\n", contract.getId(),
					contract.getDate(), contract.getInsuranceAmount(), contract.getTariffRate(),
					contract.getBranch().getName(), contract.getInsurance().getName()));
		}
		return result.toString();
	}

	public static String drawMapOfBranchesAndInsurance(List<String> list) {
		StringBuilder result = new StringBuilder();
		Resourcer resourcer = ProjectResourcer.getInstance();
		result.append(String.format("|%1$-20s|%2$-25s|\n", resourcer.getString("table.branch.name"),
				resourcer.getString("table.insurance.name"))).append("\n");
		
		for (Iterator<String> iterator = list.iterator(); iterator.hasNext();) {
			String branch = iterator.next();
			String insurance = iterator.next();
			result.append(String.format("|%1$-20s|%2$-25s|\n", branch, insurance));
		}
		return result.toString();
	}
	
	public static String drawMapOfAverageAmount(Map<String, Float> map) {
		StringBuilder result = new StringBuilder();
		Resourcer resourcer = ProjectResourcer.getInstance();
		result.append(String.format("|%1$-20s|%2$-14s|\n", resourcer.getString("table.branch.name"),
				resourcer.getString("table.statement.AverageAmount"))).append("\n");
		for (Map.Entry<String, Float> entry : map.entrySet()) {
			result.append(String.format("|%1$-20s|%2$-14s|\n", entry.getKey(), entry.getValue()));
		}
		return result.toString();
	}

}
