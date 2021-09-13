package com.ozdal.hrms.core.utilities.validationServices.concretes;



import com.ozdal.hrms.core.utilities.validationServices.abstracts.MailVarificationService;
import com.ozdal.hrms.core.utilities.validationServices.abstracts.MernisService;
import com.ozdal.hrms.core.utilities.validationServices.abstracts.PersonVerificationService;
import com.ozdal.hrms.entities.concretes.Candidate;
import com.ozdal.hrms.entities.concretes.Employer;

public class PersonVerificationManager implements PersonVerificationService{

	private MailVarificationService mailService;
	private MernisService mernisService;
	
	
	public PersonVerificationManager(MailVarificationService mailService,MernisService mernisService) {
		this.mailService=mailService;
		this.mernisService=mernisService;
	}
	public PersonVerificationManager(MailVarificationService mailService) {
		this.mailService=mailService;
	}
	
	@Override
	public boolean isPersonVerified(Candidate candidate) {
		if(mailService.isRealEMail(candidate.getUser().getEmail())  && mernisService.isRealPerson(candidate)) {
			return true;
		}
		return false;
	}

	@Override
	public boolean isEmployerVerified(Employer employer) {
		/*
		 * if(mailService.isRealEMail(employer) { return true; }
		 */
		return true;
	}

}
