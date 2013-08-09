package com.harveynash.surveyapp.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.harveynash.surveyapp.model.Question;

public class QuestionMapper implements RowMapper<Question> {

	@Override
	public Question mapRow(ResultSet rs, int rowNum) throws SQLException {
		Question question = new Question();
		question.setQuestionId(rs.getInt("questionId"));
		question.setText(rs.getString("questionText"));
		question.setQuestionType(rs.getString("Type"));
		question.setQuestionOption(rs.getString("questionOption"));
		return question;
	}

}
