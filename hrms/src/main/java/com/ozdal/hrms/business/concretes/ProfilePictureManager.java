package com.ozdal.hrms.business.concretes;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.ozdal.hrms.business.abstracts.CandidateService;
import com.ozdal.hrms.business.abstracts.ProfilePictureService;
import com.ozdal.hrms.core.utilities.adapters.CloudPicture.CloudService;
import com.ozdal.hrms.core.utilities.results.DataResult;
import com.ozdal.hrms.core.utilities.results.ErrorResult;
import com.ozdal.hrms.core.utilities.results.Result;
import com.ozdal.hrms.core.utilities.results.SuccessDataResult;
import com.ozdal.hrms.core.utilities.results.SuccessResult;
import com.ozdal.hrms.dataAccess.abstracts.ProfilePictureDao;
import com.ozdal.hrms.entities.concretes.ProfilePicture;

@Service
public class ProfilePictureManager implements ProfilePictureService{
	private ProfilePictureDao profilePictureDao;
	private CloudService cloudService;
	private CandidateService candidateService;
	
	
	@Autowired
	public ProfilePictureManager(ProfilePictureDao profilePictureDao,CloudService cloudService,CandidateService candidateService) {
		this.profilePictureDao=profilePictureDao;
		this.candidateService=candidateService;
		this.cloudService=cloudService;
	}


	@Override
	public DataResult<List<ProfilePicture>> getAll() {
		return new SuccessDataResult<List<ProfilePicture>>(this.profilePictureDao.findAll(), "Data Listelendi");
	}


	@Override
	public DataResult<ProfilePicture> getByCandidateId(int candidateId) {
		return new SuccessDataResult<ProfilePicture>(this.profilePictureDao.getByCandidateId(candidateId),"Kullanıcının bilgileri getirildi");
	}


	@Override
	public Result add(MultipartFile multipartFile, int candidateId) {
		var result=this.cloudService.upload(multipartFile);
		if(!result.isSuccess()) {
			return new ErrorResult("Hata yüklenemedi");
		}
		var candidate = this.candidateService.getById(candidateId).getData();
		ProfilePicture picture = new ProfilePicture();
		picture.setCandidate(candidate);
		picture.setPictureUrl(result.getData().get("url"));
		picture.setPublicId(result.getData().get("public_id"));
		this.profilePictureDao.save(picture);
		return new SuccessResult("Fotograf eklendi");
	}


	@Override
	public Result delete(int id) throws IOException {
		var publicId = this.profilePictureDao.findById(id).get().getPublicId();
		var result = this.cloudService.delete(publicId);
		this.profilePictureDao.deleteById(id);
        return new SuccessResult("Fotograf silindi");
	}
	
	
	
	
}
