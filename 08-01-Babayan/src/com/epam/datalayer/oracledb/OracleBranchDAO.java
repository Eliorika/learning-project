package com.epam.datalayer.oracledb;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.epam.datalayer.BranchDao;
import com.epam.datalayer.data.Branch;
import com.prutzkow.resourcer.ProjectResourcer;
import com.prutzkow.resourcer.Resourcer;

public class OracleBranchDAO implements BranchDao {
	private Connection connection;

	public OracleBranchDAO(Connection connection) {
		this.connection = connection;
	}


	public static Branch addBranch(ResultSet rs) {
		Resourcer resourcer = ProjectResourcer.getInstance();
		Branch branch = new Branch();
		try {
			branch.setId(rs.getInt(resourcer.getString("branch.id")));
			branch.setName(rs.getString(resourcer.getString("table.branch.name")));
			branch.setAdress(rs.getString(resourcer.getString("table.branch.adress")));
			branch.setPhone(rs.getString(resourcer.getString("table.branch.phone")));
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return branch;
	}

	@Override
	public Map<String, Float> getAverageAmount() {
		Map<String, Float> map = new HashMap<String, Float>();
		Resourcer resourcer = ProjectResourcer.getInstance();
		Statement st = null;
		ResultSet rs = null;
		try {
			st = this.connection.createStatement();
			rs = st.executeQuery(resourcer.getString("data.statementGroup"));
			while (rs.next()) {
				map.put(rs.getString(resourcer.getString("table.branch.name")),
						rs.getFloat(resourcer.getString("table.statement.AverageAmount")));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (st != null) {

					st.close();
				}
				if (rs != null) {
					rs.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}

		}

		return map;
	}

	@Override
	public 	List<String> getAllInsurances() {
		List<String> list = new ArrayList<String>();
		Resourcer resourcer = ProjectResourcer.getInstance();
		Statement st = null;
		ResultSet rs = null;
		try {
			st = this.connection.createStatement();
			rs = st.executeQuery(resourcer.getString("data.statementList"));
			while (rs.next()) {
				list.add(rs.getString(resourcer.getString("table.branch.name")));
				list.add(rs.getString(resourcer.getString("table.insurance.name")));

			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (st != null) {
					st.close();
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
