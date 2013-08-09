package com.harveynash.surveyapp.dao;

import java.util.List;

import javax.sql.DataSource;

import com.harveynash.surveyapp.model.User;


public interface UserDao {
	/** 
	    * This is the method to be used to initialize
	    * database resources ie. connection.
	    */
	   public void setDataSource(DataSource dataSource);
	   /** 
	    * This is the method to be used to create
	    * a record in the User table.
	    */
	   public void create(String email, String firstName, String lastName);
	   /** 
	    * This is the method to be used to list down
	    * a record from the User table corresponding
	    * to a passed User id.
	    */
	   public User getUser(Integer userId);
	   /** 
	    * This is the method to be used to list down
	    * all the records from the User table.
	    */
	   public List<User> listUser();
	   /** 
	    * This is the method to be used to delete
	    * a record from the User table corresponding
	    * to a passed User id.
	    */
	   public void delete(Integer userId);
	   /** 
	    * This is the method to be used to update
	    * a record into the User table.
	    */
	   public void update(Integer userIid, String email, String firstName, String lastName);

}
