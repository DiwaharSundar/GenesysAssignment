package com.genesys.mission.mars.model;

import java.util.List;

public class FilterCondition {

	private List<Filter> filters;

	public List<Filter> getFilters() {
		return filters;
	}

	public void setFilters(List<Filter> filters) {
		this.filters = filters;
	}

	@Override
	public String toString() {
		return "FilterCondition [filters=" + filters + "]";
	}

	
	

}
