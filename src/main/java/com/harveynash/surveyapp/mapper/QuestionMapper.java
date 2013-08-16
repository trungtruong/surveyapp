package com.harveynash.surveyapp.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.harveynash.surveyapp.model.Question;
import com.harveynash.surveyapp.model.QuestionType;

public class QuestionMapper implements RowMapper<Question> {

	@Override
	public Question mapRow(ResultSet rs, int rowNum) throws SQLException {
		Question question = new Question();
		question.setQuestionId(rs.getInt("questionId"));
		question.setQuestionText(rs.getString("questionName"));
		question.setQuestionType(QuestionType.valueOf(rs.getString("questionType")));
		return question;
	}

}
