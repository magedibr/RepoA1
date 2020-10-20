package ca.sheridancollege.AMohamed.bean;

import java.io.Serializable;
import java.time.LocalDate;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data 
@NoArgsConstructor
public class PollStat implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8552824020060361359L;





	
	private final String[] questions = {"What is your favourite Candy?","What is your favourite Sport?","What is your favourite Color?"};
	private final String[] colors= {"Red","Green","Blue"};	
    private final String[] sports= {"Football","Basketball","Tennis"};
	private final String[] candys= {"Chocolate","Taffy","Carmel"};


	//int or string for votes
	private int  votes1; 

	private int votes2; 
	private int votes3;
	private String question;
	private String candy;	
	private String sport;
	private String color;
	private int vote;
	private LocalDate when;




	private int [] votesAr= {votes1,votes2,votes3};












}	
