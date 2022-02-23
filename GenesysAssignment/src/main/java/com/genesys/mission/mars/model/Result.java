package com.genesys.mission.mars.model;

import java.util.List;

public class Result {

	private List<MarsMissionCandidate> candidates;

	public List<MarsMissionCandidate> getCandidates() {
		return candidates;
	}

	public void setCandidates(List<MarsMissionCandidate> candidates) {
		this.candidates = candidates;
	}

	public Result(List<MarsMissionCandidate> candidates) {
		super();
		this.candidates = candidates;
	}

}
