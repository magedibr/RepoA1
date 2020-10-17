package ca.sheridancollege.AMohamed.bean;

import java.io.Serializable;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data 
@NoArgsConstructor
public class PollStat implements Serializable {

 



/**
	 * 
	 */
	private static final long serialVersionUID = -9093531335512259796L;




private final String[] questions = {"What is your favourite Candy?","What is your favourite Sport?","What is your favourite Color?","What is your favourite season?"};
	



private Long id; 
private String title; 
 private String  answer1; 
private String answer2; 
private String answer3; 
private int votes1; 
private int votes2; 
private int votes3;
private String question;

}	
	