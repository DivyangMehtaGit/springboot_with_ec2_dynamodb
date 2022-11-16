package com.learn.dao;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.amazonaws.services.dynamodbv2.AmazonDynamoDB;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDBClientBuilder;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
import com.learn.controller.UserController;
import com.learn.entity.User;

@Repository
public class UserDAOImpl implements UserDao {

	Logger logger = LoggerFactory.getLogger(UserController.class);

	@Autowired
	private DynamoDBMapper dynamoDBMapper;

	public UserDAOImpl(DynamoDBMapper dynamoDBMapper) {
		this.dynamoDBMapper = dynamoDBMapper;
	}

	@Override
	public User readProduct(String pid) {
		return dynamoDBMapper.load(User.class, pid);
	}

	@Override
	public void saveUser(User user) {
		AmazonDynamoDB client = AmazonDynamoDBClientBuilder.standard().build();
		DynamoDBMapper mapper = new DynamoDBMapper(client);
		mapper.save(user);
	}
	
	@Override
	public User createUser(User user) {
		dynamoDBMapper.save(user);
		return user;
	}

}
