package com.genesys.mission.mars.model;

import java.util.Arrays;

public class Filter {

	String key;
	Object[] value;
	FilterOperator operator;

	public String getKey() {
		return key;
	}

	public void setKey(String key) {
		this.key = key;
	}

	public Object[] getValue() {
		return value;
	}

	public void setValue(Object[] value) {
		this.value = value;
	}

	public FilterOperator getOperator() {
		return operator;
	}

	public void setOperator(FilterOperator operator) {
		this.operator = operator;
	}

	@Override
	public String toString() {
		return "Filter [key=" + key + ", value=" + Arrays.toString(value) + ", operator=" + operator + "]";
	}

	public enum FilterOperator {
		EQUALS, BETWEEN
	}

}
