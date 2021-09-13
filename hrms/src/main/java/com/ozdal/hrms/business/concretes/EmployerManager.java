package com.ozdal.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ozdal.hrms.business.abstracts.EmployerService;
import com.ozdal.hrms.core.dataAccess.UserDao;
import com.ozdal.hrms.core.utilities.results.DataResult;
import com.ozdal.hrms.core.utilities.results.ErrorResult;
import com.ozdal.hrms.core.utilities.results.Result;
import com.ozdal.hrms.core.utilities.results.SuccessDataResult;
import com.ozdal.hrms.core.utilities.results.SuccessResult;
import com.ozdal.hrms.core.utilities.validationServices.concretes.MailVerificationManager;
import com.ozdal.hrms.core.utilities.validationServices.concretes.PersonVerificationManager;
import com.ozdal.hrms.dataAccess.abstracts.EmployerDao;

import com.ozdal.hrms.entities.concretes.Employer;

@Service
public class EmployerManager implements EmployerService{

	private EmployerDao employerDao;
	private UserDao userDao;
	
	@Autowired
	public EmployerManager(EmployerDao employerDao,UserDao userDao) {
		this.employerDao = employerDao;
		this.userDao=userDao;
	}

	@Override
	public DataResult<List<Employer>> getAll() {
		
		return new SuccessDataResult<List<Employer>>(this.employerDao.findAll(),"İş verenler listelendi...");
	}

	@Override
	public Result addEmployer(Employer employer) {
		PersonVerificationManager employerVerification=new PersonVerificationManager(new MailVerificationManager());
		
		if(employerVerification.isEmployerVerified(employer)) {
			this.userDao.save(employer.getUser());
			this.employerDao.save(employer);
			return new SuccessResult("İş veren eklendi...");
		}
		return new ErrorResult("Bilgileriniz hatalı");
	}

}
