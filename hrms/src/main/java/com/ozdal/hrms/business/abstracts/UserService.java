package com.ozdal.hrms.business.abstracts;

import java.util.List;

import com.ozdal.hrms.core.entities.User;
import com.ozdal.hrms.core.utilities.results.DataResult;
import com.ozdal.hrms.core.utilities.results.Result;


public interface UserService {
	
	DataResult<List<User>> getAll();
	Result addUser(User user);
	

}
