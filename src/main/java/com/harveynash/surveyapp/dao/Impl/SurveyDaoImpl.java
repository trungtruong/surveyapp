package com.harveynash.surveyapp.dao.Impl;

import java.sql.Date;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;

import com.harveynash.surveyapp.dao.SurveyDao;
import com.harveynash.surveyapp.mapper.SurveyMapper;
import com.harveynash.surveyapp.model.Survey;

public class SurveyDaoImpl implements SurveyDao {
	private DataSource dataSource;
	private JdbcTemplate jdbcTemplateObject;
	
	@Override
	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
		this.jdbcTemplateObject = new JdbcTemplate(dataSource);
	}

	@Override
	public void create(String surveyName, Date startDate, Date endDate) {
		String SQL = "insert into Survey (surveyName,startDate,endDate) values (?,?,?)";
		jdbcTemplateObject.update(SQL, surveyName,startDate,endDate);
		return;
	}

	@Override
	public Survey getSurvey(Integer surveyId) {
		String SQL = "select * from Survey where surveyId = ?";
		Survey survey = jdbcTemplateObject.queryForObject(SQL, new Object[] {surveyId}, new SurveyMapper());
		return survey;
	}

	@Override
	public List<Survey> listSurveys() {
		String SQL = "select * from Survey";
	      List <Survey> surveys = jdbcTemplateObject.query(SQL, 
	                                new SurveyMapper());
		return surveys;
	}

	@Override
	public void delete(Integer surveyId) {
		String SQL = "delete from Survey where surveyId = ?";
	    jdbcTemplateObject.update(SQL, surveyId);
	    return;

	}

	@Override
	public void update(Integer surveyId, String surveyName, Date startDate,
			Date endDate) {
		String SQL = "update Survey set surveyName = ?,startDate = ?,endDate = ? where surveyId = ?";
	    jdbcTemplateObject.update(SQL, surveyName, startDate, endDate, surveyId);
	    return;

	}

	@Override
	public Integer getSurveyId(String surveyName, Date startDate, Date endDate) {
		String SQL = "select surveyId from Survey where surveyName = ?, startDate = ?, endDate = ?";
		Integer surveyId = jdbcTemplateObject.queryForInt(SQL, new Object[] {surveyName, startDate, endDate});
		return surveyId;
	}

}
