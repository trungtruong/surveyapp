package com.harveynash.surveyapp.service.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.harveynash.surveyapp.dao.UserDao;
import com.harveynash.surveyapp.model.User;
import com.harveynash.surveyapp.service.UserManager;

@Service
public class UserManagerImpl implements UserManager {
	
    @Autowired
    UserDao userDao;

	@Override
	public List<User> getUserList(Integer surveyId) {
		return userDao.listUser(surveyId);
	}

	@Override
	public void createUser(User user, Integer surveyId) {
		userDao.create(user.getEmail(), user.getFirstName(), user.getLastName(),surveyId);		
	}

	@Override
	public User getUserByUserId(Integer userId) {
		return userDao.getUser(userId);
	}
	

}
