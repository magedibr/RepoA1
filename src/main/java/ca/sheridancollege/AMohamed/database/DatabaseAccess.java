package ca.sheridancollege.AMohamed.database;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import ca.sheridancollege.AMohamed.bean.PollStat;

@Repository
public class DatabaseAccess {

	@Autowired
	protected NamedParameterJdbcTemplate jdbc;
	
	public void insertV(int vote1,int vote2,int vote3,String q,PollStat pollstat) {
	
		
		MapSqlParameterSource namedParameters = new MapSqlParameterSource();
		
		if(vote1==1) {
			
			String query="INSERT INTO POLLSTAT(question,votes1,votes2,votes3) VALUES (:question,1,0,0)";
			
			
			namedParameters.addValue("question",q );
			namedParameters.addValue("vote1",1);
			namedParameters.addValue("vote2",0);
			namedParameters.addValue("vote3",0);
			namedParameters.addValue("pollStat", pollstat);
			
			
			
			
			
			int rowsAffected = jdbc.update(query,namedParameters );
			
			if(rowsAffected==1)
			System.out.println(rowsAffected);
			else System.out.println("1 added");
        
		}
		else if(vote2==1) {
			
			System.out.println(vote2);
			
			
			String query="INSERT INTO POLLSTAT(question,votes1,votes2,votes3) VALUES (:question,0,1,0)";
	
			namedParameters.addValue("question",q );
			namedParameters.addValue("vote1",0);
			namedParameters.addValue("vote2",1);
			namedParameters.addValue("vote3",0);
			
			int rowsAffected = jdbc.update(query,namedParameters);
			
			if(rowsAffected==1)
			System.out.println(rowsAffected);
			else System.out.println("1 added");
        
		} else {
			
			System.out.println("V3");
			
			String query="INSERT INTO POLLSTAT(question,votes1,votes2,votes3) VALUES (:question,0,0,1)";
			
			namedParameters.addValue("question",q);
			namedParameters.addValue("vote1",0);
			namedParameters.addValue("vote2",0);
			namedParameters.addValue("vote3",1);
			
			int rowsAffected = jdbc.update(query,namedParameters);
			
			if(rowsAffected!=1)
			System.out.println(rowsAffected);
			else System.out.println("1 not added");	
					}
				}
	
	
	
	
	
	public List<PollStat> getStatList(){
		
		//To use for parameter
		MapSqlParameterSource namedParameters = new MapSqlParameterSource();
		
		String query = "SELECT COUNT(VOTES1) FROM POLLSTAT";
		
		//Converts the rows that are fetched from the student to student objects so that can they be shown on the html. 
		return jdbc.query(query, namedParameters, new BeanPropertyRowMapper<PollStat>(PollStat.class));
		
		
		
		
	}
	}
	
	
	
	
	

