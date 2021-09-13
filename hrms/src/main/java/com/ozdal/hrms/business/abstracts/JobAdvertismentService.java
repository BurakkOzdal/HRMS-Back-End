package com.ozdal.hrms.business.abstracts;


import java.util.List;

import com.ozdal.hrms.core.utilities.results.DataResult;
import com.ozdal.hrms.core.utilities.results.Result;
import com.ozdal.hrms.entities.concretes.JobAdvertisement;
public interface JobAdvertismentService {
	
	DataResult<List<JobAdvertisement>> getAll();
	Result addJobAvertisement (JobAdvertisement jobAdvertisement);
	DataResult <List<JobAdvertisement>> getByStatusTrue(); 
	DataResult<List<JobAdvertisement>> getByEmployer(int employerId);
}
