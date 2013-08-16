package com.harveynash.surveyapp.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Date;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

import com.harveynash.surveyapp.adapter.DateAdapter;

@XmlRootElement (name = "survey")
@XmlAccessorType(XmlAccessType.FIELD)
public class Survey {
    
    @XmlTransient
    private int surveyId;

    private String surveyName;
    
    @XmlElement(name ="question")
    private List<Question> questionList;
    
    @XmlElement(name ="user")
    private List<User> userList;

    @XmlElement(name ="startDate")
    @XmlJavaTypeAdapter(DateAdapter.class)
    private Date startDate;
    
    @XmlElement(name ="endDate")
    @XmlJavaTypeAdapter(DateAdapter.class)
    private Date endDate;

    public List<User> getUserList() {
		return userList;
	}
	public void setUserList(List<User> userList) {
		this.userList = userList;
	}

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