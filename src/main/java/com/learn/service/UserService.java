package com.learn.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.learn.entity.User;

@Service
public interface UserService {

	User readProduct(String uid);

	void saveUser(User user);

	User createUser(User user);

}
