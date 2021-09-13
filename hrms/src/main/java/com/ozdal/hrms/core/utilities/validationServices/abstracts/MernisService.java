package com.ozdal.hrms.core.utilities.validationServices.abstracts;

import com.ozdal.hrms.entities.concretes.Candidate;

public interface MernisService {
	boolean isRealPerson(Candidate candidate);

}
