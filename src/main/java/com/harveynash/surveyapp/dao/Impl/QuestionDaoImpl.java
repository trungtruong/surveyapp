package com.harveynash.surveyapp.dao.Impl;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.harveynash.surveyapp.dao.QuestionDao;
import com.harveynash.surveyapp.mapper.QuestionMapper;
import com.harveynash.surveyapp.model.Question;
import com.harveynash.surveyapp.model.QuestionOption;
import com.harveynash.surveyapp.model.QuestionType;

@Repository
public class QuestionDaoImpl implements QuestionDao{
    
    @Autowired
	private DataSource dataSource;
    
	private JdbcTemplate jdbcTemplateObject;

	@Override
	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
		this.jdbcTemplateObject = new JdbcTemplate(dataSource);
		
	}

	@Override
	public void create(String questionText, QuestionType questionType,
			QuestionOption questionOption, Integer surveyId) {
		String SQL = "insert into Question (questionText, questionType, surveyId) values (?, ?, ?)";
		jdbcTemplateObject.update(SQL,questionText,questionType, surveyId);
		return;	
		
	}

	@Override
	public Question getQuestion(Integer questionId) {
		String SQL = "select * from Question where questionId = ?";
		Question question = jdbcTemplateObject.queryForObject(SQL, new Object[] {questionId}, new QuestionMapper());
		return question;
	}

	@Override
	public List<Question> listQuestions(Integer surveyId) {
		String SQL = "select * from Question where surveyId = ?";
	    List <Question> questions = jdbcTemplateObject.query(SQL, new Object[] {surveyId},
	                                new QuestionMapper());
	    return questions;
	}

	@Override
	public void delete(Integer questionId) {
		String SQL = "delete from Question where questionId = ?";
	     jdbcTemplateObject.update(SQL, questionId);
	     return;
		
	}

	@Override
	public void update(Integer questionId, String questionText,
			QuestionType questionType, QuestionOption questionOption) {
		String SQL = "update Question set questionName = ?, questionType = ? where userId = ?";
	    jdbcTemplateObject.update(SQL, questionText,questionType,questionId);
	    return;
		
	}

	

}
