package com.harveynash.surveyapp.dao.Impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import com.harveynash.surveyapp.dao.SurveyDao;
import com.harveynash.surveyapp.mapper.SurveyMapper;
import com.harveynash.surveyapp.model.Survey;

@Repository
public class SurveyDaoImpl implements SurveyDao {
    
    @Autowired
	private DataSource dataSource;
    
	private JdbcTemplate jdbcTemplateObject;
	
	@Override
	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
		this.jdbcTemplateObject = new JdbcTemplate(dataSource);
	}

	@Override
	public int create(final String surveyName, final Date startDate, final Date endDate) {
		final String SQL = "insert into Survey (surveyName,startDate,endDate) values (?,?,?)";
		KeyHolder keyHolder = new GeneratedKeyHolder();
		
		PreparedStatementCreator preparedStatementCreator = new PreparedStatementCreator() {
            
            @Override
            public java.sql.PreparedStatement createPreparedStatement(Connection con) throws SQLException {
            
                PreparedStatement pStatement = con.prepareStatement(SQL, new String[] {"surveyId"});
                
                pStatement.setString(1, surveyName);
                pStatement.setTimestamp(2, new Timestamp(startDate.getTime()));
                pStatement.setTimestamp(3, new Timestamp(endDate.getTime()));
                return pStatement;
            }
        };
        
		jdbcTemplateObject.update(preparedStatementCreator, keyHolder);

		return keyHolder.getKey().intValue();
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
}
