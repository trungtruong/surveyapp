package com.harveynash.surveyapp.service;

import java.util.List;

import com.harveynash.surveyapp.model.User;

public interface UserManager {
	public List<User> getUserList(Integer surveyId);
	public void createUser(User user, Integer surveyId);
	public User getUserByUserId(Integer userId);

}
