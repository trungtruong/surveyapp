package com.harveynash.surveyapp.dao.Impl;

import java.util.List;

import javax.sql.DataSource;

import com.harveynash.surveyapp.dao.QuestionDao;
import com.harveynash.surveyapp.model.Question;
import com.harveynash.surveyapp.model.QuestionOption;
import com.harveynash.surveyapp.model.QuestionType;


public class QuestionDaoImpl implements QuestionDao{

	@Override
	public void setDataSource(DataSource dataSource) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void create(String questionText, QuestionType questionType,
			QuestionOption questionOption) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Question getQuestion(Integer questionId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Question> listUser() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void delete(Integer questionId) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void update(Integer questionId, String questionText,
			QuestionType questionType, QuestionOption questionOption) {
		// TODO Auto-generated method stub
		
	}

	

}
