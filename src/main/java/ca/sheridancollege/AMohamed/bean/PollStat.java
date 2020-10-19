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
	private static final long serialVersionUID = 8552824020060361359L;






private final String[] candys= {"Chocolate","Taffy","Candy","dsadasd"};



	private final String[] questions = {"What is your favourite Candy?","What is your favourite Sport?","What is your favourite Color?"};
	
	private String title; 



	private int votes1; 
	private int votes2; 
	private int votes3;
	private String question;
	private String candy;





	private final int [] votes= {votes1,votes2,votes3};




}	
