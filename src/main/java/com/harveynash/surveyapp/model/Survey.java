package com.harveynash.surveyapp.model;

import java.util.ArrayList;
import java.util.List;
import java.sql.Date;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

@XmlRootElement (name = "survey")
@XmlAccessorType(XmlAccessType.NONE)
public class Survey {
    
    @XmlTransient
    private int surveyId;
    
    @XmlElement
    private String surveyName;
    
    @XmlElement
    private List<Question> questionList;
    
    @XmlElement
    private Date startDate;
    
    @XmlElement
    private Date endDate;
    
    public Integer getSurveyId() {
        return surveyId;
    }
    public void setSurveyId(Integer surveyId) {
        this.surveyId = surveyId;
    }
    
    public String getSurveyName() {
        return surveyName;
    }
    public void setSurveyName(String surveyName) {
        this.surveyName = surveyName;
    }
    
    public List<Question> getQuestionList() {
    
        return questionList;
    }
    
    public void setQuestionList(List<Question> questionList) {
    
    this.questionList = questionList;
    }
    public Date getStartDate() {
        return startDate;
    }
    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }
    public Date getEndDate() {
        return endDate;
    }
    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public Survey() {
        this.questionList = new ArrayList<Question>();
    }
}