package com.epam.datalayer;


import java.util.List;

import com.epam.datalayer.data.Contract;

public interface ContractDao {
	List<Contract> getListOfContractsBetweenDates(String date1, String date2);
	

}
