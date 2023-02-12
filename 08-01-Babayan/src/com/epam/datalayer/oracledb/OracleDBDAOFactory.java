package com.epam.datalayer.oracledb;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import com.epam.datalayer.DAOFactory;
import com.epam.datalayer.data.Contract;
import com.prutzkow.resourcer.ProjectResourcer;
import com.prutzkow.resourcer.Resourcer;

import ru.rsreu.Babayan0801.TableDrawer;

public class OracleDBDAOFactory extends DAOFactory {
	private static volatile OracleDBDAOFactory instance;
	private Connection connection;

	private OracleDBDAOFactory() {
	}

	public static OracleDBDAOFactory getInstance() throws ClassNotFoundException, SQLException {
		OracleDBDAOFactory factory = instance;
		if (instance == null) {
			synchronized (OracleDBDAOFactory.class) {
				instance = factory = new OracleDBDAOFactory();
				factory.connected();
			}
		}
		return factory;
	}

	private void connected() throws ClassNotFoundException, SQLException {
		Locale.setDefault(Locale.ENGLISH);
		Resourcer resourcer = ProjectResourcer.getInstance();
		String url = resourcer.getString("data.url");
		String user = resourcer.getString("data.user");
		String password = resourcer.getString("data.password");
		connection = DriverManager.getConnection(url, user, password);
		System.out.println("Connected to oracle DB!");
	}

	@Override
	public List<Contract> findInformationAboutConractsBetweenDates(String date1, String date2) {
		OracleContractDAO contractDAO = new OracleContractDAO(connection);
		List<Contract> list = contractDAO.getListOfContractsBetweenDates(date1, date2);
		return list;
	}

	@Override
	public List<String> findBranchesAndInsurances() {
		OracleBranchDAO branchDao = new OracleBranchDAO(connection);
		List<String> list = branchDao.getAllInsurances();
		return list;
	}

	@Override
	public Map<String, Float> findAvarageSum() {
		OracleBranchDAO branchDao = new OracleBranchDAO(connection);
		Map<String, Float> map = branchDao.getAverageAmount();
		return map;
	}

	@Override
	public String resultOfStatesmans(String date1, String date2) {
		Resourcer resourcer = ProjectResourcer.getInstance();
		StringBuilder result = new StringBuilder();
		result.append(resourcer.getString("message.dateStatementAnswer")).append(" ").append(date1).append(" ")
				.append(resourcer.getString("message.and")).append(" ").append(date2).append("\n");
		List<Contract> list = findInformationAboutConractsBetweenDates(date1, date2);
		result.append(TableDrawer.drawContractList(list)).append("\n");
		
		result.append(resourcer.getString("message.listStatementAnswer")).append("\n");
		List<String> list2 = findBranchesAndInsurances();
		result.append(TableDrawer.drawMapOfBranchesAndInsurance(list2)).append("\n");
		
		result.append(resourcer.getString("message.groupStatementAnswer")).append("\n");
		Map<String, Float> map2 = findAvarageSum();
		result.append(TableDrawer.drawMapOfAverageAmount(map2)).append("\n");
		
		try {
			connection.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result.toString();
	}
	
}
