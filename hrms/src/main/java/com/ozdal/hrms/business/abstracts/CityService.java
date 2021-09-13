package com.ozdal.hrms.business.abstracts;

import java.util.List;

import com.ozdal.hrms.core.utilities.results.DataResult;
import com.ozdal.hrms.core.utilities.results.Result;
import com.ozdal.hrms.entities.concretes.City;

public interface CityService {
	
	DataResult<List<City>> getAll();
	Result addCity(City city);

}
