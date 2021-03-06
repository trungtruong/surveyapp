package com.harveynash.surveyapp.dao.Impl;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.harveynash.surveyapp.dao.UserDao;
import com.harveynash.surveyapp.mapper.UserMapper;
import com.harveynash.surveyapp.model.User;

@Repository
public class UserDaoImpl implements UserDao{
    
    @Autowired
	private DataSource dataSource;
	private JdbcTemplate jdbcTemplateObject;

	@Override
	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
		this.jdbcTemplateObject = new JdbcTemplate(dataSource);		
	}

	@Override
	public void create(String email, String firstName, String lastName, Integer surveyId) {
		String SQL = "insert into User_Survey (email, firstName, lastName, surveyId) values (?, ?, ?, ?)";
		jdbcTemplateObject.update(SQL,email,firstName,lastName,surveyId);
		return;		
	}

	@Override
	public User getUser(Integer userId) {
		String SQL = "select * from User_Survey where userId = ?";
		User user = jdbcTemplateObject.queryForObject(SQL, new Object[] {userId}, new UserMapper());
		return user;
	}

	@Override
	public List<User> listUser(Integer surveyId) {
		String SQL = "select * from User_Survey where surveyId = ?";
	      List <User> users = jdbcTemplateObject.query(SQL, new Object[] {surveyId},
	                                new UserMapper());
	      return users;
	}

	@Override
	public void delete(Integer surveyId) {
		 String SQL = "delete from User_Survey where surveyId = ?";
	     jdbcTemplateObject.update(SQL, surveyId);
	     return;
	}

	@Override
	public void update(Integer userId, String email, String firstName,
			String lastName) {
		String SQL = "update User_Survey set email = ?, firstName = ?, lastName = ? where userId = ?";
	    jdbcTemplateObject.update(SQL, email,firstName,lastName,userId);
	    return;		
	}

}
