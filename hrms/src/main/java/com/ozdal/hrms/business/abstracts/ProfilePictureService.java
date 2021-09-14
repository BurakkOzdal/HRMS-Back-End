package com.ozdal.hrms.business.abstracts;

import java.io.IOException;
import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.ozdal.hrms.core.utilities.results.DataResult;
import com.ozdal.hrms.core.utilities.results.Result;
import com.ozdal.hrms.entities.concretes.ProfilePicture;

public interface ProfilePictureService {
	DataResult<List<ProfilePicture>> getAll();
	DataResult<ProfilePicture> getByCandidateId(int candidateId);
	
	Result add(MultipartFile multipartFile, int candidateId);
	Result delete(int id) throws IOException;

}
