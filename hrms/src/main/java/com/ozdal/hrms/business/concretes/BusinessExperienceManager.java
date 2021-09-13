package com.ozdal.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ozdal.hrms.business.abstracts.BusinessExperienceService;
import com.ozdal.hrms.core.utilities.results.DataResult;
import com.ozdal.hrms.core.utilities.results.Result;
import com.ozdal.hrms.core.utilities.results.SuccessDataResult;
import com.ozdal.hrms.core.utilities.results.SuccessResult;
import com.ozdal.hrms.dataAccess.abstracts.BusinessExperienceDao;
import com.ozdal.hrms.entities.concretes.BusinessExperience;

@Service
public class BusinessExperienceManager implements BusinessExperienceService{

	private BusinessExperienceDao businessExperienceDao;
	
	@Autowired
	public BusinessExperienceManager(BusinessExperienceDao businessExperienceDao) {
		this.businessExperienceDao=businessExperienceDao;
	}

	@Override
	public DataResult<List<BusinessExperience>> getAll() {
		
		return new SuccessDataResult<List<BusinessExperience>>(this.businessExperienceDao.findAll(),"Data Listelendi");
	}

	@Override
	public Result addExperience(BusinessExperience experience) {
		if(!experience.isJobStatus()) {
			experience.setFinishDate("Devam ediyor");
		}
		
		this.businessExperienceDao.save(experience);
		return new SuccessResult("Data Listelendi");
	}
	
	
}
