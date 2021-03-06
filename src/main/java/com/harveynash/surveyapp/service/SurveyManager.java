package com.harveynash.surveyapp.service;

import java.util.List;

import com.harveynash.surveyapp.model.Survey;

public interface SurveyManager {
    public List<Survey> getSurveyList();
    public Survey getSurveyDetail(Integer surveyId);
    public void createSurvey(Survey survey);
    public void deleteSurvey(Integer surveyId);
}
