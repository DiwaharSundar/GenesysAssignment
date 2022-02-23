package com.genesys.mission.mars.model;

import java.math.BigInteger;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "MarsMissionCandidate")
public class MarsMissionCandidate {

	@Id
	private BigInteger candidateId;
	private String name;
	private int age;
	private String country;
	private int weight;
	private int height;
	private boolean exercise;
	private Fitness fitness;

	public enum Fitness {
		FIT, UNFIT
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public int getWeight() {
		return weight;
	}

	public void setWeight(int weight) {
		this.weight = weight;
	}

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}

	public BigInteger getCandidateId() {
		return candidateId;
	}

	public void setCandidateId(BigInteger candidateId) {
		this.candidateId = candidateId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public boolean isExercise() {
		return exercise;
	}

	public void setExercise(boolean exercise) {
		this.exercise = exercise;
	}

	public Fitness getFitness() {
		return fitness;
	}

	public void setFitness(Fitness fitness) {
		this.fitness = fitness;
	}

	@Override
	public String toString() {
		return "MarsMissionCandidate [candidateId=" + candidateId + ", name=" + name + ", age=" + age + ", country="
				+ country + ", weight=" + weight + ", height=" + height + ", exercise=" + exercise + ", fitness="
				+ fitness + "]";
	}

}
