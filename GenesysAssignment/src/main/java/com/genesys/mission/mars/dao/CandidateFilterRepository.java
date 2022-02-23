package com.genesys.mission.mars.dao;

import java.util.List;

import com.genesys.mission.mars.model.FilterCondition;
import com.genesys.mission.mars.model.MarsMissionCandidate;

/**
 * 
 * Custom Repository Class for Mongo DB
 * @author Diwahar
 *
 */
public interface CandidateFilterRepository {

	List<MarsMissionCandidate> findCandidateByFilterProperties(FilterCondition filterCondition);
	
}
