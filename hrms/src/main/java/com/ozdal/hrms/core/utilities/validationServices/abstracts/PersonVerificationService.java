package com.ozdal.hrms.core.utilities.validationServices.abstracts;

import com.ozdal.hrms.entities.concretes.Candidate;
import com.ozdal.hrms.entities.concretes.Employer;

public interface PersonVerificationService {
	boolean isPersonVerified(Candidate candidate);
	boolean isEmployerVerified(Employer employer);

}
