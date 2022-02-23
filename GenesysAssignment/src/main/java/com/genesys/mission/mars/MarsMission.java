package com.genesys.mission.mars;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class MarsMission {
	
	public static void main(String[] args) {
		SpringApplication.run(MarsMission.class, args);
		System.out.println("App Started");
	}

}
