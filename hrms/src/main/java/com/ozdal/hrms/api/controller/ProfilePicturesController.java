package com.ozdal.hrms.api.controller;

import java.io.IOException;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.ozdal.hrms.business.abstracts.ProfilePictureService;
import com.ozdal.hrms.core.utilities.results.DataResult;
import com.ozdal.hrms.core.utilities.results.Result;
import com.ozdal.hrms.entities.concretes.ProfilePicture;

@RestController
@RequestMapping("/api/profilepictures")
public class ProfilePicturesController {

	
	private ProfilePictureService profilePictureService;

	public ProfilePicturesController(ProfilePictureService profilePictureService) {
		this.profilePictureService = profilePictureService;
	}
	
	@PostMapping("/add")
	public Result add(@RequestPart MultipartFile image, int candidateId) {
		return this.profilePictureService.add(image, candidateId);
	}
	@GetMapping("/getById")
	public DataResult<ProfilePicture> getById(int candidateId){
		return this.profilePictureService.getByCandidateId(candidateId);
	}
	
	@GetMapping("/delete")
	public Result delete(int id) throws IOException {
		return this.profilePictureService.delete(id);
	}
	
}
