package com.ozdal.hrms.core.dataAccess;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ozdal.hrms.core.entities.User;



public interface UserDao extends JpaRepository<User, Integer>{

}
