package com.harveynash.surveyapp.model;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

@XmlRootElement(name = "question")
@XmlAccessorType(XmlAccessType.NONE)
public class Question {
    
    @XmlTransient
    private int questionId;
    
    @XmlElement
    private String questionText;
    
    @XmlElement
    private QuestionType questionType = QuestionType.TEXT;
    
    @XmlElement
    private QuestionOption questionOption = null;
    
    public int getQuestionId() {
    
        return questionId;
    }

    public void setQuestionId(int questionId) {
    
        this.questionId = questionId;
    }

    public void setText(String text) {
        this.questionText = text;
    }
    
    public String getText () {
        return questionText;
    }
    
    public void setQuestionType(QuestionType type) {

        this.questionType = type;
    }
    
    public QuestionType getQuestionType() {

        return questionType;
    }
    
    public void setQuestionOption(QuestionOption option) {

        this.questionOption = option;
    }
    public QuestionOption getQuestionOption() {

        return questionOption;
    }
}
