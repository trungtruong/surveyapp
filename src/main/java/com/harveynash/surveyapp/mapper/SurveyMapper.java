package com.harveynash.surveyapp.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;

import com.harveynash.surveyapp.model.Survey;

public class SurveyMapper implements RowMapper<Survey> {
	public Survey mapRow(ResultSet rs, int rowNum) throws SQLException {
    Survey survey = new Survey();
    survey.setSurveyId(rs.getInt("surveyId"));
    survey.setSurveyName(rs.getString("surveyName"));
    survey.setStartDate(rs.getDate("startDate"));
    survey.setEndDate(rs.getDate("endDate"));
	return survey;
	}
}
