package com.ozdal.hrms.business.concretes;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ozdal.hrms.business.abstracts.UserService;
import com.ozdal.hrms.core.dataAccess.UserDao;
import com.ozdal.hrms.core.entities.User;
import com.ozdal.hrms.core.utilities.results.DataResult;
import com.ozdal.hrms.core.utilities.results.Result;
import com.ozdal.hrms.core.utilities.results.SuccessDataResult;
import com.ozdal.hrms.core.utilities.results.SuccessResult;


@Service
public class UserManager implements UserService{

	private UserDao userDao;
	
	@Autowired
	public UserManager(UserDao userDao) {
		super();
		this.userDao = userDao;
	}

	@Override
	public DataResult<List<User>> getAll() {
		
		return new SuccessDataResult<List<User>>(this.userDao.findAll(),"Kullanıcılar listelendi...") ;
	}

	@Override
	public Result addUser(User user) {
		this.userDao.save(user);
		return new SuccessResult("Kullanıcı eklendi...");
	}

}
