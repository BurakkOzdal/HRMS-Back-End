package com.ozdal.hrms.core.utilities.validationServices.concretes;

import com.ozdal.hrms.core.utilities.validationServices.abstracts.MernisService;
import com.ozdal.hrms.entities.concretes.Candidate;

public class MernisManager implements MernisService{

	@Override
	public boolean isRealPerson(Candidate candidate) {
		if(candidate.getIdentityNumber().length() == 11) {
			return true;
		}
		return false;
	}

}
