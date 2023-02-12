package com.epam.datalayer;

import java.util.List;
import java.util.Map;

public interface BranchDao {
	Map<String, Float> getAverageAmount();
	List<String> getAllInsurances();

}
