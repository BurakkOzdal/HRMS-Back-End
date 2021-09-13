package com.ozdal.hrms.business.abstracts;

import java.util.List;

import com.ozdal.hrms.core.utilities.results.DataResult;
import com.ozdal.hrms.core.utilities.results.Result;
import com.ozdal.hrms.entities.concretes.ForeignLanguage;

public interface ForeignLanguageService {
	
	DataResult<List<ForeignLanguage>> getAll();
	Result addForeignLanguage(ForeignLanguage foreignLanguage);
 
}
