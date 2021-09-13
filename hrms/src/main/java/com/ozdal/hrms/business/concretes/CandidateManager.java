package com.ozdal.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ozdal.hrms.business.abstracts.CandidateService;
import com.ozdal.hrms.core.utilities.results.DataResult;
import com.ozdal.hrms.core.utilities.results.ErrorResult;
import com.ozdal.hrms.core.utilities.results.Result;
import com.ozdal.hrms.core.utilities.results.SuccessDataResult;
import com.ozdal.hrms.core.utilities.results.SuccessResult;
import com.ozdal.hrms.core.utilities.validationServices.concretes.MailVerificationManager;
import com.ozdal.hrms.core.utilities.validationServices.concretes.MernisManager;
import com.ozdal.hrms.core.utilities.validationServices.concretes.PersonVerificationManager;
import com.ozdal.hrms.dataAccess.abstracts.CandidateDao;
import com.ozdal.hrms.dataAccess.abstracts.UserDao;
import com.ozdal.hrms.entities.concretes.Candidate;

@Service
public class CandidateManager implements CandidateService{

	private CandidateDao candidateDao;
	private UserDao userDao;
	
	
	@Autowired
	public CandidateManager(CandidateDao candidateDao,UserDao userDao) {
		this.candidateDao = candidateDao;
	
		this.userDao=userDao;
	}
	
	@Override
	public DataResult<List<Candidate>> getAll() {
		return new SuccessDataResult<List<Candidate>>(this.candidateDao.findAll(),"İş arayanlar listelendi...");
	}

	@Override
	public Result addCandidate(Candidate candidate) {
		
		PersonVerificationManager candidateVerification=new PersonVerificationManager(new MailVerificationManager(), new MernisManager());
		
			if(candidateVerification.isPersonVerified(candidate)) {
			this.userDao.save(candidate.getUser());
			this.candidateDao.save(candidate);
			return new SuccessResult("İş arayan eklendi...");
			}
			return new ErrorResult("Bilgilerinizi kontrol ediniz...");
	}
	
}
