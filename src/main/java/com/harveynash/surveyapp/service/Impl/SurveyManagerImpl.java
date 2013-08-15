package com.harveynash.surveyapp.service.Impl;

import java.util.List;

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
    
    private SurveyDao surveyDao;
    private UserManager userManager;
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
		surveyDao.create(survey.getSurveyName(), survey.getStartDate(), survey.getEndDate());
		survey.setSurveyId(surveyDao.getSurveyId(survey.getSurveyName(), survey.getStartDate(), survey.getEndDate()));
		
		//Create Question for Survey
		for(Question question : questions) {
			questionManager.createQuestion(question, survey.getSurveyId());
		}
		
		////Create User for Survey
		for(User user : users) {
			userManager.createUser(user, survey.getSurveyId());
		}
		
	}

}
