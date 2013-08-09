package com.harveynash.surveyapp.model;


import javax.xml.bind.annotation.XmlTransient;

public class Question {
    
    @XmlTransient
    private int questionId;
    
    private String questionText;
    
    private QuestionType questionType;
    
    private QuestionOption questionOption = null;

    
    public int getQuestionId() {
    
        return questionId;
    }

    
    public void setQuestionId(int questionId) {
    
        this.questionId = questionId;
    }

    
    public String getQuestionText() {
    
        return questionText;
    }

    
    public void setQuestionText(String questionText) {
    
        this.questionText = questionText;
    }

    
    public QuestionType getQuestionType() {
    
        return questionType;
    }

    
    public void setQuestionType(QuestionType questionType) {
    
        this.questionType = questionType;
    }

    
    public QuestionOption getQuestionOption() {
    
        return questionOption;
    }

    
    public void setQuestionOption(QuestionOption questionOption) {
    
        this.questionOption = questionOption;
    }

}
