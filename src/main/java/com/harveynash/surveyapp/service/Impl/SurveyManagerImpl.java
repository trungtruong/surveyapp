package com.harveynash.surveyapp.service.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.harveynash.surveyapp.dao.SurveyDao;
import com.harveynash.surveyapp.model.Survey;
import com.harveynash.surveyapp.service.SurveyManager;

@Service
public class SurveyManagerImpl implements SurveyManager {
    
    @Autowired
    private SurveyDao surveyDao;

    @Override
    public List<Survey> getSurveyList() {
        return surveyDao.listSurveys();
    }

}
