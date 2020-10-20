package ca.sheridancollege.AMohamed.controllers;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import org.springframework.beans.factory.annotation.Autowired;
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
                 model.addAttribute("pollList",da.getStatList());
			} 
			
			if(CandyAns.equalsIgnoreCase("Taffy"))     {da.insertV(0,1,0,"What is your favourite Candy?",pollStat);
														} 	
			if(CandyAns.equalsIgnoreCase("Carmel"))    {da.insertV(0, 0, 1,"What is your favourite Candy?",pollStat);} 
					
		
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

		}
		 pollStat.setQuestion("trial"); 
     //    model.addAttribute("pollStat",pollStat);
		 String[] Qs ={"What is your favourite Candy?","What is your favourite Sport?","What is your favourite Color?"};   
         int vote1=0;
         
		      for(PollStat i : da.getStatList()) {

				
				if(i.getQuestion().equalsIgnoreCase(Qs[0])&&i.getVotes1()==1) {
					
					
			    
					
				    pollStat.setVote(++vote1);
				    pollStat.setQuestion("Sdad");
					//model.addAttribute("pollStat",pollStat);
					
				}
			     
				}
         
         
         
         
 	
		
	
		return "results";

	}



public String result(Model model,@ModelAttribute PollStat pollStat ) {
	
	int vote1=0;
	int vote2=0;
	int vote3=0;
    String[] Qs ={"What is your favourite Candy?","What is your favourite Sport?","What is your favourite Color?"};   
	
//	model.addAttribute("pollStat",new PollStat());
	model.addAttribute("pollList",da.getStatList());
    
	for(PollStat i : da.getStatList()) {

	
	if(i.getQuestion().equalsIgnoreCase(Qs[0])&&i.getVotes1()==1) {
		
		vote1+=1;
    
		
		model.addAttribute("qqq",Qs[0]);
	
		model.addAttribute("pollStat",pollStat);
		
       
     
	}else if(i.getQuestion().equalsIgnoreCase(Qs[0])&&i.getVotes2()==1) {
    

		vote2+=1;
        System.out.println("V2 "+vote2);}
	
	    else if(i.getQuestion().equalsIgnoreCase(Qs[0])&&i.getVotes3()==1) {
	
	    vote3+=1;
		System.out.println("V3 "+vote3);

   
			
	}


}
	

	
	
	return "results";
	
	
	
}
	
	
	
	
	
	

}







