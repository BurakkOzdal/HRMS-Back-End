package com.ozdal.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ozdal.hrms.business.abstracts.ForeignLanguageService;
import com.ozdal.hrms.core.utilities.results.DataResult;
import com.ozdal.hrms.core.utilities.results.Result;
import com.ozdal.hrms.core.utilities.results.SuccessDataResult;
import com.ozdal.hrms.core.utilities.results.SuccessResult;
import com.ozdal.hrms.dataAccess.abstracts.ForeignLanguageDao;
import com.ozdal.hrms.entities.concretes.ForeignLanguage;

@Service
public class ForeignLanguageManager implements ForeignLanguageService{
	private ForeignLanguageDao foreignLanguageDao;
	
	@Autowired
	public ForeignLanguageManager (ForeignLanguageDao foreignLanguageDao) {
		this.foreignLanguageDao=foreignLanguageDao;
	}

	@Override
	public DataResult<List<ForeignLanguage>> getAll() {
		return new SuccessDataResult<List<ForeignLanguage>>(this.foreignLanguageDao.findAll(),"Data Listelendi");
	}

	@Override
	public Result addForeignLanguage(ForeignLanguage foreignLanguage) {
		this.foreignLanguageDao.save(foreignLanguage);
		return new SuccessResult("Dil Eklendi");
	}
	
	
}
