package com.genesys.mission.mars.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.genesys.mission.mars.model.AuthenticationRequest;
import com.genesys.mission.mars.model.AuthenticationResponse;
import com.genesys.mission.mars.model.FilterCondition;
import com.genesys.mission.mars.model.Result;
import com.genesys.mission.mars.security.EmployeeUserDetailService;
import com.genesys.mission.mars.security.JwtUtil;
import com.genesys.mission.mars.service.CandidateFilterService;

/**
 * 
 * Controller Class that hosts REST Webservices
 * @author Diwahar
 *
 */
@RestController
public class MarsMissionController {
	
	Logger logger = (Logger) LoggerFactory.getLogger(MarsMissionController.class);
	
	@Autowired
	AuthenticationManager authenticationManager;
	
	@Autowired
	CandidateFilterService candidateFilterService;
	
	@Autowired
	JwtUtil jwtTokenUtil;
	
	@Autowired
	EmployeeUserDetailService employeeDetailService;
	

	/**
	 * Dummy Service to check if the Application is up 
	 */
	@GetMapping("/hello")
	public String sayHello() {
		return "Hello World!";
	}

	/**
	 * Webservice to Filter Candidates based on input filter condition.
	 * @param filterCondition
	 * @return
	 */
	@RequestMapping(value = "/filter", method=RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public Result filterParticipants(@RequestBody FilterCondition filterCondition) {
		logger.info("Received a filter Condition "+filterCondition);
		return new Result(candidateFilterService.filterCandidate(filterCondition));
	}

	/**
	 * Authenticate REST Method to authenticate the user for the first time
	 * @param authenticationRequest
	 * @return
	 */
	@RequestMapping(value = "/authenticate", method=RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<AuthenticationResponse> filterCandidate(@RequestBody AuthenticationRequest authenticationRequest) {
		try {
			authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(
					authenticationRequest.getUsername(), authenticationRequest.getPassword()));
		} catch (Exception ex) {
			throw new BadCredentialsException("Invalid UserName or Password");
		}
		
		final UserDetails userDetails = employeeDetailService.
				loadUserByUsername(authenticationRequest.getUsername());
		String jwt = jwtTokenUtil.generateToken(userDetails);
		return ResponseEntity.ok(new AuthenticationResponse(jwt));
	}
	
}
