package com.learn.service;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;

import com.amazonaws.client.builder.AwsClientBuilder;
import com.amazonaws.services.dynamodbv2.model.ResourceNotFoundException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.learn.controller.UserController;
import com.learn.dao.UserDao;
import com.learn.entity.User;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private Environment env;

	@Autowired
	private UserDao userDao;

	public UserServiceImpl(UserDao productDao) {
		this.userDao = productDao;
	}

	static Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);

	@Override
	public User readProduct(String uid) {
		logger.info("uid  UserServiceImpl" + uid);
		return userDao.readProduct(uid);
	}

	@Override
	public void saveUser(User user) {
		logger.info("user  UserServiceImpl" + user);
		userDao.saveUser(user);
	}

	@Override
	public User createUser(User user) {
		return userDao.createUser(user);
	}

	
}
