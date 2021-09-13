package com.ozdal.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ozdal.hrms.business.abstracts.JobAdvertismentService;
import com.ozdal.hrms.core.utilities.results.DataResult;
import com.ozdal.hrms.core.utilities.results.Result;
import com.ozdal.hrms.core.utilities.results.SuccessDataResult;
import com.ozdal.hrms.core.utilities.results.SuccessResult;
import com.ozdal.hrms.dataAccess.abstracts.JobAdvertismentDao;
import com.ozdal.hrms.entities.concretes.JobAdvertisement;

@Service
public class JobAdvertismentManager implements JobAdvertismentService {
	
	private JobAdvertismentDao jobAdvertisement;
	
	@Autowired
	public JobAdvertismentManager(JobAdvertismentDao jobAdvertisement) {
		this.jobAdvertisement=jobAdvertisement;
	}

	@Override
	public DataResult<List<JobAdvertisement>> getAll() {
		
		return new SuccessDataResult<List<JobAdvertisement>>(this.jobAdvertisement.findAll(),"İlanlar listelendi");
	}

	@Override
	public Result addJobAvertisement(JobAdvertisement jobAdvertisement) {
		this.jobAdvertisement.save(jobAdvertisement);
		return new SuccessResult("İlan başarıyla eklendi...");
	}

	@Override
	public DataResult<List<JobAdvertisement>> getByStatusTrue() {
		
		return new SuccessDataResult<List<JobAdvertisement>>(this.jobAdvertisement.findByStatusTrue(),"Aktif ilanlar listelendi");
	}

	@Override
	public DataResult<List<JobAdvertisement>> getByEmployer(int employerId) {
		
		return new SuccessDataResult<List<JobAdvertisement>>(this.jobAdvertisement.getByEmployer_id(employerId),"İş verenin ilanları listelendi");
	}

}
