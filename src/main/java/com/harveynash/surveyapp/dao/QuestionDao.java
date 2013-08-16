package com.harveynash.surveyapp.dao;

import java.util.List;

import javax.sql.DataSource;

import com.harveynash.surveyapp.model.Question;
import com.harveynash.surveyapp.model.QuestionOption;
import com.harveynash.surveyapp.model.QuestionType;


public interface QuestionDao {
	/** 
	    * This is the method to be used to initialize
	    * database resources ie. connection.
	    */
	   public void setDataSource(DataSource dataSource);
	   /** 
	    * This is the method to be used to create
	    * a record in the Question table.
	    */
	   public void create(String questionText, QuestionType questionType, QuestionOption questionOption, Integer surveyId);
	   /** 
	    * This is the method to be used to list down
	    * a record from the User table corresponding
	    * to a passed Question id.
	    */
	   public Question getQuestion(Integer questionId);
	   /** 
	    * This is the method to be used to list down
	    * all the records from the Question table.
	    */
	   public List<Question> listQuestions(Integer surveyId);
	   /** 
	    * This is the method to be used to delete
	    * a record from the Question table corresponding
	    * to a passed Question id.
	    */
	   public void delete(Integer questionId);
	   /** 
	    * This is the method to be used to update
	    * a record into the Question table.
	    */
	   public void update(Integer questionId, String questionText, QuestionType questionType, QuestionOption questionOption);

}
