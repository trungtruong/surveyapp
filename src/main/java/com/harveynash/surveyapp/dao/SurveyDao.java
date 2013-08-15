package com.harveynash.surveyapp.dao;

import java.sql.Date;
import java.util.List;

import javax.sql.DataSource;

import com.harveynash.surveyapp.model.Survey;

public interface SurveyDao {
	/** 
	    * This is the method to be used to initialize
	    * database resources ie. connection.
	    */
	   public void setDataSource(DataSource ds);
	   /** 
	    * This is the method to be used to create
	    * a record in the Survey table.
	    */
	   public void create(String surveyName, Date startDate, Date endDate);
	   /** 
	    * This is the method to be used to list down
	    * a record from the Survey table corresponding
	    * to a passed Survey id.
	    */
	   public Survey getSurvey(Integer surveyId);
	   /** 
	    * This is the method to be used to list down
	    * all the records from the Survey table.
	    */
	   public Integer getSurveyId(String surveyName, Date startDate, Date endDate);
	   /** 
	    * This is the method to be used to list down
	    * all the records from the Survey table.
	    */
	   public List<Survey> listSurveys();
	   /** 
	    * This is the method to be used to delete
	    * a record from the Student table corresponding
	    * to a passed student id.
	    */
	   public void delete(Integer surveyId);
	   /** 
	    * This is the method to be used to update
	    * a record into the Student table.
	    */
	   public void update(Integer surveyId, String surveyName, Date startDate, Date endDate);

}
