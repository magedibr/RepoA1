package ca.sheridancollege.AMohamed.controllers;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import ca.sheridancollege.AMohamed.bean.PollStat;
import ca.sheridancollege.AMohamed.database.DatabaseAccess;

@Controller
public class PollStatController {
	@Autowired
	DatabaseAccess da;

    int i =0;

	List<PollStat> pollList= new CopyOnWriteArrayList<PollStat>(); 



	@GetMapping("/")
	public String index(Model model) {
		model.addAttribute("pollStat",new PollStat());
		model.addAttribute("pollList",pollList);

		return "index";

	}
	

	
	
	
	
	@PostMapping("/addQuestion")
	public String questionChoice(Model model,@ModelAttribute PollStat pollStat) {

		
		System.out.println("Got here");

		model.addAttribute("pollStat",pollStat);
	
		model.addAttribute("pollList", da.getStatList());  
		
		
	//	model.addAttribute("pollList", da.getStatList()); 

		return "poll";
	}


	
	
	@PostMapping("/getAnswer")
	public String answerChoice(Model model,@ModelAttribute PollStat pollStat) {


		if(pollStat.getCandy() != null){	

			String CandyAns =  pollStat.getCandy();

			if(CandyAns.equalsIgnoreCase("Chocolate")) {
			
			   	da.insertV(1, 0, 0,"What is your favourite Candy?",pollStat);
			
			//    pollList.add(pollStat);
                 model.addAttribute("pollList",da.getStatList());
			
		      //model.addAttribute("pollStat",new PollStat());
			} 
			
			
			
			if(CandyAns.equalsIgnoreCase("Taffy"))     {da.insertV(0,1,0,"What is your favourite Candy?",pollStat);
														} 	
			if(CandyAns.equalsIgnoreCase("Carmel"))    {da.insertV(0, 0, 1,"What is your favourite Candy?",pollStat);} 
					
		//	pollList.add(pollStat);
		}else if(pollStat.getSport()!= null) {

			String SportAns = pollStat.getSport();


			if(SportAns.equalsIgnoreCase("Football")) { da.insertV(1, 0, 0,"What is your favourite Sport?",pollStat);} 
			if(SportAns.equalsIgnoreCase("Basketball")) {da.insertV(0,1,0,"What is your favourite Sport?",pollStat);} 	
			if(SportAns.equalsIgnoreCase("Tennis")) {da.insertV(0, 0, 1,"What is your favourite Sport?",pollStat);} 

		} else if(pollStat.getColor()!= null) {

			String ColAns = pollStat.getColor();

			if(ColAns.equalsIgnoreCase("Red")) { da.insertV(1, 0, 0,"What is your favourite Color?",pollStat);} 
			if(ColAns.equalsIgnoreCase("Green"))     {da.insertV(0,1,0,"What is your favourite Color?",pollStat);} 	
			if(ColAns.equalsIgnoreCase("Blue")) {da.insertV(0, 0, 1,"What is your favourite Color?",pollStat);} 	

		}else System.out.println("Non were chosen");

	
		return result(model,pollStat);

	}


	
@GetMapping("/results")
public String result(Model model,@ModelAttribute PollStat pollStat) {
	
	model.addAttribute("pollList",da.getStatList());
	
for(PollStat i : da.getStatList()) {
	System.out.println(i.getQuestion());
	if(i.getQuestion().equalsIgnoreCase("What is your favourite Sport?")) {
	
     System.out.println(i.getVotes1());}
	else System.out.println("No the sports question");








}
	
	
	
	
	return "results";
	
	
	
}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}







