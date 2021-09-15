package com.ozdal.hrms.business.abstracts;

import com.ozdal.hrms.core.utilities.results.DataResult;
import com.ozdal.hrms.core.utilities.results.Result;
import com.ozdal.hrms.entities.concretes.CoverLetter;

public interface CoverLetterService {

	DataResult<CoverLetter>getByCandidateId(int candidateId);
	Result addCoverLetter(CoverLetter coverLetter);
}
