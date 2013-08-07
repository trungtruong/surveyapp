package com.harveynash.surveyapp.model;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "question")
public class Question {
    int id;
    String text;
    QuestionType type = QuestionType.TEXT;
    QuestionOption option = null;
    
    @XmlElement
    public void setText(String text) {
        this.text = text;
    }
    
    public String getText () {
        return text;
    }
    
    @XmlElement
    public void setQuestionType(QuestionType type) {

        this.type = type;
    }
    
    public QuestionType getQuestionType() {

        return type;
    }
    
    @XmlElement
    public void setQuestionOption(QuestionOption option) {

        this.option = option;
    }
    public QuestionOption getQuestionOption() {

        return option;
    }
}
