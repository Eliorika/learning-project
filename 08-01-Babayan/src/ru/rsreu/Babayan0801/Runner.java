package ru.rsreu.Babayan0801;

import com.epam.datalayer.DAOFactory;
import com.epam.datalayer.DBType;
import com.epam.datalayer.DBTypeException;

public class Runner {

	public static final String DATE1 = "2005-01-01";
	public static final String DATE2 = "2016-01-01";

	private Runner() {
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			DAOFactory factory = DAOFactory.getInstance(DBType.ORACLE);

			System.out.println(factory.resultOfStatesmans(DATE1, DATE2));
		} catch (DBTypeException e) {
			e.printStackTrace();
		}
	}

}
