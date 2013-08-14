package com.harveynash.surveyapp.service;

import java.util.List;

import com.harveynash.surveyapp.model.Question;

public interface QuestionManager {
	public List<Question> getQuestionList(Integer surveyId);
	public void createQuestion(Question question);
	public Question getQuestionByQuestionId(Integer questionId);

}
