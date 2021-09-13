package com.ozdal.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ozdal.hrms.business.abstracts.SchoolService;
import com.ozdal.hrms.core.utilities.results.DataResult;
import com.ozdal.hrms.core.utilities.results.Result;
import com.ozdal.hrms.core.utilities.results.SuccessDataResult;
import com.ozdal.hrms.core.utilities.results.SuccessResult;
import com.ozdal.hrms.dataAccess.abstracts.SchoolDao;
import com.ozdal.hrms.entities.concretes.School;

@Service
public class SchoolManager implements SchoolService{

	
	private SchoolDao schoolDao;

	@Autowired
	public SchoolManager(SchoolDao schoolDao) {
		this.schoolDao=schoolDao;
	}

	@Override
	public DataResult<List<School>> getAll() {
		
		return new SuccessDataResult<List<School>>(this.schoolDao.findAll(),"Data listelendi");
	}

	@Override
	public Result addSchool(School school) {
		
		if(!school.isGraduatedStatus()) {
			school.setFinishDate("Devam ediyor");
		}
		this.schoolDao.save(school);
		return new SuccessResult("Okul eklendi");
	}
	
}
