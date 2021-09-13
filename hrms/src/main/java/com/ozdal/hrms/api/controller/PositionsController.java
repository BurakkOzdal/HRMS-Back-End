package com.ozdal.hrms.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ozdal.hrms.business.abstracts.PositionService;
import com.ozdal.hrms.core.utilities.results.DataResult;
import com.ozdal.hrms.core.utilities.results.Result;
import com.ozdal.hrms.entities.concretes.Position;


@RestController
@RequestMapping("/api/positions")
public class PositionsController {

	private PositionService positionService;
	
	@Autowired
	public PositionsController(PositionService positionService) {
		this.positionService=positionService;
	}
	
	
	@GetMapping("/getall")
	public DataResult<List<Position>> getAll(){
		
		return this.positionService.getAll();
	}
	
	@PostMapping("/add")
	public Result addPosition (@RequestBody Position position) {
		return this.positionService.addPosition(position);
	}
	
}
