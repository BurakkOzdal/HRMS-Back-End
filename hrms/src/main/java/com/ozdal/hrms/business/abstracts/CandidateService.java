package com.ozdal.hrms.business.abstracts;

import java.util.List;

import com.ozdal.hrms.core.utilities.results.DataResult;
import com.ozdal.hrms.core.utilities.results.Result;
import com.ozdal.hrms.entities.concretes.Candidate;

public interface CandidateService {
	DataResult<List<Candidate>> getAll();
	Result addCandidate(Candidate candidate);
	DataResult<Candidate> getById(int candidateId);
}
