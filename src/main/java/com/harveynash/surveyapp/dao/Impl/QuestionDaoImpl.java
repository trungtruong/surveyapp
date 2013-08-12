package com.harveynash.surveyapp.dao.Impl;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;

import com.harveynash.surveyapp.dao.QuestionDao;
import com.harveynash.surveyapp.mapper.QuestionMapper;
import com.harveynash.surveyapp.mapper.UserMapper;
import com.harveynash.surveyapp.model.Question;
import com.harveynash.surveyapp.model.QuestionOption;
import com.harveynash.surveyapp.model.QuestionType;
import com.harveynash.surveyapp.model.User;


public class QuestionDaoImpl implements QuestionDao{
	private DataSource dataSource;
	private JdbcTemplate jdbcTemplateObject;

	@Override
	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
		this.jdbcTemplateObject = new JdbcTemplate(dataSource);
		
	}

	@Override
	public void create(String questionText, QuestionType questionType,
			QuestionOption questionOption) {
		String SQL = "insert into Question (questionText, QuestionType) values (?, ?)";
		jdbcTemplateObject.update(SQL,questionText,questionType);
		return;	
		
	}

	@Override
	public Question getQuestion(Integer questionId) {
		String SQL = "select * from Question where questionId = ?";
		Question question = jdbcTemplateObject.queryForObject(SQL, new Object[] {questionId}, new QuestionMapper());
		return question;
	}

	@Override
	public List<Question> listUser() {
		String SQL = "select * from Question";
	    List <Question> questions = jdbcTemplateObject.query(SQL, 
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
