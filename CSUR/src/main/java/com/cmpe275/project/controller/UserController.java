package com.cmpe275.project.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.cmpe275.project.mapper.SignInResponse;
import com.cmpe275.project.mapper.UserResponse;
import com.cmpe275.project.model.User;
import com.cmpe275.project.services.UserService;
import com.cmpe275.project.validators.Validator;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
public class UserController {

	@Autowired
	UserService userService;
	@Autowired
	private BCryptPasswordEncoder passwordEncoder;

	@RequestMapping(path = "/signup",method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> createUser(@RequestBody User userRequest) {
		UserResponse userResponse = new UserResponse();
		boolean isValid = Validator.validateCreateUserRequest(userRequest, userResponse);
		ResponseEntity res = null;
		HttpStatus httpStatus = null;

		if (isValid) {

			if (userService.findUserByEmail(userRequest.getEmail()) != null) {
				userResponse.setMsg("User with entered email already exist. Please enter a different email.");
				httpStatus = HttpStatus.BAD_REQUEST;
			} else {
				
				User user = new User();
				user.setEmail(userRequest.getEmail());
				user.setFirstname(userRequest.getFirstname());
				user.setLastname(userRequest.getLastname());
				user.setPassword(passwordEncoder.encode(userRequest.getPassword()));

				User savedUser = userService.createUser(user);
				userResponse.setUser(savedUser);
				userResponse.setMsg("Successfull created a new User");
				httpStatus = HttpStatus.OK;
			}
		} else {
			httpStatus = HttpStatus.BAD_REQUEST;
		}

		res = new ResponseEntity(userResponse, httpStatus);

		return res;

	}

	@GetMapping(path = "/user/{userId}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> getUser(@PathVariable(value = "userId") String userId) {

		UserResponse userResponse = new UserResponse();
		ResponseEntity res = null;
		HttpStatus httpStatus = null;
		User user = userService.getUser(userId);
		if (user != null) {
			userResponse.setUser(user);
			userResponse.setMsg("Successfully Retrieved User Details.");
			httpStatus = HttpStatus.OK;
		} else {
			userResponse.setMsg("User does not exist");
			httpStatus = HttpStatus.NOT_FOUND;
		}

		res = new ResponseEntity(userResponse, httpStatus);
		return res;
	}
	
	@RequestMapping(path = "/signin/{mode}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> userSignin(@RequestBody User userRequest, @PathVariable(value = "mode") String mode) {

		ResponseEntity res = null;
		SignInResponse signinResponse = new SignInResponse();
		if(mode != null && !mode.equalsIgnoreCase("none")) {
			User user = userService.findUserByEmail(userRequest.getEmail());
			if(user != null) {
				signinResponse.setUser(user);
			}
			else {				
				user = new User();
				user.setEmail(userRequest.getEmail());
				signinResponse.setUser(userService.createUser(user));				
			}
			signinResponse.setLoggedIn(true);
			signinResponse.setCode(200);
			signinResponse.setMsg("Login Successful.");			
		}
		else {
			signinResponse = userService.userSignIn(userRequest);
			
		}
		
		res = new ResponseEntity(signinResponse, HttpStatus.OK);
		
		return res;
	}
	

}
