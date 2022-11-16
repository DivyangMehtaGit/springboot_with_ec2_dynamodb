package com.learn.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.amazonaws.AmazonClientException;
import com.amazonaws.AmazonServiceException;
import com.learn.entity.User;
import com.learn.service.UserService;

@RestController
@CrossOrigin(origins = "*")
public class UserController {


	@Autowired
	private UserService userservice;

	public UserController(UserService userservice) {
		this.userservice = userservice;
	}

	Logger logger = LoggerFactory.getLogger(UserController.class);

	@GetMapping("/user/{uid}")
	public ResponseEntity<User> readProduct(@PathVariable String uid) {
		logger.info("uid  " + uid);
		try {

			logger.info("uid aaa " + uid);
			User response = userservice.readProduct(uid);

			logger.info("uid bbb " + uid);

			return ResponseEntity.status(HttpStatus.OK).body(response);
		} catch (AmazonServiceException e) {
			throw new ResponseStatusException(HttpStatus.valueOf(e.getStatusCode()), e.getMessage(), e);
		} catch (AmazonClientException e) {
			throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, e.getMessage(), e);
		}
	}

	@PostMapping("/user")
	public ResponseEntity<User> createUser(@RequestBody User user) {
		logger.info("user  " + user);
		try {
			logger.info("user to be added " + user);
			User response = userservice.createUser(user);
			logger.info("user added " + user);
			return ResponseEntity.status(HttpStatus.CREATED).body(response);
		} catch (AmazonServiceException e) {
			throw new ResponseStatusException(HttpStatus.valueOf(e.getStatusCode()), e.getMessage(), e);
		} catch (AmazonClientException e) {
			throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, e.getMessage(), e);
		}
	}

}
