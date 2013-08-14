package com.harveynash.surveyapp.service.Impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.harveynash.surveyapp.dao.QuestionDao;
import com.harveynash.surveyapp.model.Question;
import com.harveynash.surveyapp.service.QuestionManager;

@Service
public class QuestionManagerImpl implements QuestionManager {
	private QuestionDao questionDao;

	@Override
	public List<Question> getQuestionList(Integer surveyId) {
		return questionDao.listQuestions(surveyId);
	}

	@Override
	public void createQuestion(Question question) {
		questionDao.create(question.getQuestionText(), question.getQuestionType(), question.getQuestionOption());
		
	}

	@Override
	public Question getQuestionByQuestionId(Integer questionId) {
		return questionDao.getQuestion(questionId);
	}

}
