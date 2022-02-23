package com.genesys.mission.mars.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.genesys.mission.mars.dao.CandidateFilterRepository;
import com.genesys.mission.mars.model.FilterCondition;
import com.genesys.mission.mars.model.MarsMissionCandidate;

/**
 * Service Class for Filter Services
 * @author Diwahar
 *
 */
@Service
public class CandidateFilterService {
	
	Logger logger = LoggerFactory.getLogger(CandidateFilterService.class);
	
	@Autowired
	CandidateFilterRepository candidateFilterRepository;
	
	/**
	 * 
	 * @param filterCondition
	 * @return
	 */
	public List<MarsMissionCandidate> filterCandidate(FilterCondition filterCondition) {
		return candidateFilterRepository.findCandidateByFilterProperties(filterCondition);
	}
	
}
