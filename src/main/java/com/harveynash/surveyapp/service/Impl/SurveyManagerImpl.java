package com.harveynash.surveyapp.service.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.harveynash.surveyapp.dao.QuestionDao;
import com.harveynash.surveyapp.dao.SurveyDao;
import com.harveynash.surveyapp.dao.UserDao;
import com.harveynash.surveyapp.model.Question;
import com.harveynash.surveyapp.model.Survey;
import com.harveynash.surveyapp.model.User;
import com.harveynash.surveyapp.service.SurveyManager;

@Service
public class SurveyManagerImpl implements SurveyManager {
    
    @Autowired
    private SurveyDao surveyDao;
    private UserDao userDao;
    private QuestionDao questionDao;

    @Override
    public List<Survey> getSurveyList() {
        return surveyDao.listSurveys();
    }

	@Override
	public Survey getSurveyDetail(Integer surveyId) {
		List<Question> questions;
		List<User> users;
		Survey survey;
		
		questions = questionDao.listQuestions(surveyId);
		users = userDao.listUser(surveyId);
		survey = surveyDao.getSurvey(surveyId);
		survey.setQuestionList(questions);
		survey.setUserList(users);
		
		return survey;
	}

}
