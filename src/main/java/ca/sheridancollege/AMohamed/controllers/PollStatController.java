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


	List<PollStat> statList= new CopyOnWriteArrayList<PollStat>(); 



	@GetMapping("/")
	public String index(Model model) {



		model.addAttribute("pollStat",new PollStat());
		model.addAttribute("statList", statList);

		return "index";

	}
	@PostMapping("/addQuestion")
	public String questionChoice(Model model,@ModelAttribute PollStat pollStat) {

		System.out.println("Got here");


		// model.addAttribute("pollStat",new PollStat());	

		statList.add(pollStat);
		model.addAttribute("statList", statList);
		model.addAttribute("pollStat",pollStat);



		return "poll";
	}


	@PostMapping("/getAnswer")
	public String answerChoice(Model model,@ModelAttribute PollStat pollStat) {

		//	statList.add(pollStat);
		//model.addAttribute(" ", attributeValue);


		String answ = pollStat.getCandy();	
		

		if(answ.equalsIgnoreCase("Chocolate")) {System.out.println("Choco");} 
		if(answ.equalsIgnoreCase("Taffy"))     {System.out.println("Taffy");} 	
		if(answ.equalsIgnoreCase("Carmel")) {System.out.println("Carmel");} 	    






		return "results";

	}



}







