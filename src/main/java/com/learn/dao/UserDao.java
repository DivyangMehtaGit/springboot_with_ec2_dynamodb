package com.learn.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.learn.entity.User;

@Repository
public interface UserDao {

	public User readProduct(String userId);

	public void saveUser(User user);

	public User createUser(User user);

}
