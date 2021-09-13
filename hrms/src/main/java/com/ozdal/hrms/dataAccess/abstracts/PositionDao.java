package com.ozdal.hrms.dataAccess.abstracts;



import org.springframework.data.jpa.repository.JpaRepository;


import com.ozdal.hrms.entities.concretes.Position;

public interface PositionDao extends JpaRepository<Position,Integer>{
	
}
