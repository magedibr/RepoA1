package ca.sheridancollege.AMohamed.database;
import ca.sheridancollege.AMohamed.bean.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class DatabaseAccess {

	@Autowired
	protected NamedParameterJdbcTemplate jdbc;
	
	public void insertCandyPoll(PollStat poll) {
		
		MapSqlParameterSource namedParameters = new MapSqlParameterSource();
		

		
	    String l = poll.getCandy();
		System.out.println(l);
		
		
		
		
		
		
		
		
		
		
		
		
		
	}
	
	
	
	
	
	
}
