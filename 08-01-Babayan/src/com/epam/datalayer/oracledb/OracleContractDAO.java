package com.epam.datalayer.oracledb;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.epam.datalayer.ContractDao;
import com.epam.datalayer.data.Contract;
import com.prutzkow.resourcer.ProjectResourcer;
import com.prutzkow.resourcer.Resourcer;

public class OracleContractDAO implements ContractDao {
private Connection connection;
	
	public OracleContractDAO(Connection connection) {
		this.connection = connection;
	}



	public Contract addContract(ResultSet rs) {
		Resourcer resourcer = ProjectResourcer.getInstance();
		Contract contract = new Contract();
		try {
			contract.setId(rs.getInt(resourcer.getString("contract.id")));
			Date date = rs.getDate(resourcer.getString("table.contract.date"));
			SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
			contract.setDate(formatter.format(date));
			contract.setInsuranceAmount(rs.getFloat(resourcer.getString("table.contract.amount")));
			contract.setTariffRate(rs.getFloat(resourcer.getString("table.contract.tariff")));
			contract.setBranch(OracleBranchDAO.addBranch(rs));
			contract.setInsurance(OracleInsuranceDAO.addInsurance(rs));
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return contract;
	}
	


	@Override
	public List<Contract> getListOfContractsBetweenDates(String date1, String date2) {
		List<Contract> list = new ArrayList<Contract>();
		Resourcer resourcer = ProjectResourcer.getInstance();
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			ps = this.connection.prepareStatement(resourcer.getString("data.statementDate"));
			ps.setDate(1, java.sql.Date.valueOf(date1));
			ps.setDate(2, java.sql.Date.valueOf(date2));
			rs = ps.executeQuery();
			while (rs.next()) {
				Contract contract = addContract(rs);
				list.add(contract);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (ps != null) {

					ps.close();
				}
				if (rs != null) {
					rs.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return list;
	}

}
