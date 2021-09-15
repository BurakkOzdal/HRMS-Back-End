package com.ozdal.hrms.business.concretes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ozdal.hrms.business.abstracts.CoverLetterService;
import com.ozdal.hrms.core.utilities.results.DataResult;
import com.ozdal.hrms.core.utilities.results.Result;
import com.ozdal.hrms.core.utilities.results.SuccessDataResult;
import com.ozdal.hrms.core.utilities.results.SuccessResult;
import com.ozdal.hrms.dataAccess.abstracts.CoverLetterDao;
import com.ozdal.hrms.entities.concretes.CoverLetter;

@Service
public class CoverLetterManager implements CoverLetterService{

	private CoverLetterDao coverLetterDao;

	@Autowired
	public CoverLetterManager(CoverLetterDao coverLetterDao) {
		this.coverLetterDao = coverLetterDao;
	}

	@Override
	public DataResult<CoverLetter> getByCandidateId(int candidateId) {
		return new SuccessDataResult<CoverLetter>(this.coverLetterDao.getByCandidateId(candidateId), "Önyazı getirildi");
	}

	@Override
	public Result addCoverLetter(CoverLetter coverLetter) {
		this.coverLetterDao.save(coverLetter);
		return new SuccessResult("Önyazı eklendi");
	}
	
	
	
}
