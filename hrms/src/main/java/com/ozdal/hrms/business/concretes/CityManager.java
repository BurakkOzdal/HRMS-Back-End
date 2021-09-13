package com.ozdal.hrms.business.concretes;

import java.util.List;

import org.springframework.stereotype.Service;

import com.ozdal.hrms.business.abstracts.CityService;
import com.ozdal.hrms.core.utilities.results.DataResult;
import com.ozdal.hrms.core.utilities.results.Result;
import com.ozdal.hrms.core.utilities.results.SuccessDataResult;
import com.ozdal.hrms.core.utilities.results.SuccessResult;
import com.ozdal.hrms.dataAccess.abstracts.CityDao;
import com.ozdal.hrms.entities.concretes.City;

@Service
public class CityManager implements CityService{
	private CityDao cityDao;
	
	
	public CityManager(CityDao cityDao) {
		this.cityDao=cityDao;
	}


	@Override
	public DataResult<List<City>> getAll() {
		return new SuccessDataResult<List<City>>(this.cityDao.findAll(),"Data Listelendi...");
	}


	@Override
	public Result addCity(City city) {
		this.cityDao.save(city);
		return new SuccessResult("Şehir eklendi...");
		
	}
	
	
}
