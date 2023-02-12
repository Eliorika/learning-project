package com.epam.datalayer.oracledb;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.epam.datalayer.InsuranceDao;
import com.epam.datalayer.data.Insurance;
import com.prutzkow.resourcer.ProjectResourcer;
import com.prutzkow.resourcer.Resourcer;

public class OracleInsuranceDAO implements InsuranceDao {
	
	public static Insurance addInsurance(ResultSet rs) {
		Resourcer resourcer = ProjectResourcer.getInstance();
		Insurance insurance = new Insurance();
			try {
				insurance.setId(rs.getInt(resourcer.getString("insurance.id")));
				insurance.setName(rs.getString(resourcer.getString("table.insurance.name")));
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
		return insurance;
	}

}
