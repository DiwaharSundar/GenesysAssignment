package com.genesys.mission.mars.dao;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

import com.genesys.mission.mars.exceptions.FilterMisMatchException;
import com.genesys.mission.mars.model.Filter;
import com.genesys.mission.mars.model.Filter.FilterOperator;
import com.genesys.mission.mars.model.FilterCondition;
import com.genesys.mission.mars.model.MarsMissionCandidate;

/**
 * Repository Class which builds Criteria having multiple properties.
 * @author Diwahar
 *
 */
@Repository
public class CandidateFilterRepositoryImpl implements CandidateFilterRepository {

	Logger logger = LoggerFactory.getLogger(CandidateFilterRepositoryImpl.class);

	@Autowired
	MongoTemplate mongoTemplate;

	public List<MarsMissionCandidate> findCandidateByFilterProperties(FilterCondition filterCondition) {
		final Query query = new Query();
		final List<Criteria> criteria = new ArrayList<Criteria>();

		for (Filter filter : filterCondition.getFilters()) {
			logger.info("Filter - " + filter);
			addCriteria(criteria, filter);
		}

		query.addCriteria(new Criteria().andOperator(criteria.toArray(new Criteria[criteria.size()])));
		return  queryMongoDb(query, MarsMissionCandidate.class);
	}

	private void addCriteria(List<Criteria> criteria, Filter filter) {
		FilterOperator filterOperator = filter.getOperator();
		
		switch (filterOperator) {
			
		case EQUALS:
			validateEqualsFilter(filter);
			criteria.add(Criteria.where(filter.getKey()).is(filter.getValue()[0]));
			break;

		case BETWEEN:
			validateBetweenFilter(filter);
			criteria.add(Criteria.where(filter.getKey()).gte(filter.getValue()[0]).lt(filter.getValue()[1]));
			break;
		}
	}
	
	private void validateEqualsFilter(Filter filter) {
		if (filter.getValue().length > 1)
			throw new FilterMisMatchException("Too Many Arguments for Filter having EQUALS Operator");
	}
	
	private void validateBetweenFilter(Filter filter) {
		if (filter.getValue().length != 2)
			throw new FilterMisMatchException("Values for Filter having BETWEEN Operator must be 2");
	}
	
	private List<MarsMissionCandidate> queryMongoDb(Query query, Class classs) {
		return mongoTemplate.find(query, classs);
	}

}
