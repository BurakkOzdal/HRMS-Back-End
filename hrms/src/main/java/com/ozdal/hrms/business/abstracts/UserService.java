package com.ozdal.hrms.business.abstracts;

import java.util.List;

import com.ozdal.hrms.core.utilities.results.DataResult;
import com.ozdal.hrms.core.utilities.results.Result;
import com.ozdal.hrms.entities.concretes.User;

public interface UserService {
	
	DataResult<List<User>> getAll();
	Result addUser(User user);
	

}
