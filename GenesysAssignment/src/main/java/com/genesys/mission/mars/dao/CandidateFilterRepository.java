package com.genesys.mission.mars.dao;

import java.util.List;

import com.genesys.mission.mars.model.FilterCondition;
import com.genesys.mission.mars.model.MarsMissionCandidate;

public interface CandidateFilterRepository {

	List<MarsMissionCandidate> findCandidateByFilterProperties(FilterCondition filterCondition);
	
}
