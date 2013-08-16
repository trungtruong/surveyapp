package com.harveynash.surveyapp.service.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.harveynash.surveyapp.dao.SurveyDao;
import com.harveynash.surveyapp.model.Question;
import com.harveynash.surveyapp.model.Survey;
import com.harveynash.surveyapp.model.User;
import com.harveynash.surveyapp.service.QuestionManager;
import com.harveynash.surveyapp.service.SurveyManager;
import com.harveynash.surveyapp.service.UserManager;

@Service
public class SurveyManagerImpl implements SurveyManager {
    
    @Autowired
    private SurveyDao surveyDao;
    
    @Autowired
    private UserManager userManager;
    
    @Autowired
    private QuestionManager questionManager;

    @Override
    public List<Survey> getSurveyList() {
        return surveyDao.listSurveys();
    }

	@Override
	public Survey getSurveyDetail(Integer surveyId) {
		List<Question> questions;
		List<User> users;
		Survey survey;
		
		questions = questionManager.getQuestionList(surveyId);
		users = userManager.getUserList(surveyId);
		survey = surveyDao.getSurvey(surveyId);
		survey.setQuestionList(questions);
		survey.setUserList(users);
		
		return survey;
	}

	@Override
	public void createSurvey(Survey survey) {
		List<Question> questions = survey.getQuestionList();
		List<User> users= survey.getUserList();
		
		// Create Survey
	    int surveyId = surveyDao.create(survey.getSurveyName(), survey.getStartDate(), survey.getEndDate());
		
		//Create Question for Survey
		for(Question question : questions) {
			questionManager.createQuestion(question, surveyId);
		}
		
		////Create User for Survey
		for(User user : users) {
			userManager.createUser(user, surveyId);
		}
		
	}

}
