package ca.sheridancollege.AMohamed.controllers;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import ca.sheridancollege.AMohamed.bean.PollStat;

@Controller
public class PollStatController {

	List<PollStat> statList= new CopyOnWriteArrayList<PollStat>(); 
	
	
	
	@GetMapping("/")
	public String index(Model model) {
		
	//PollStat pollStat = new PollStat();
		//pollStat.setTitle("hello");
		
		//model.addAttribute("pol", attributeValue)
		model.addAttribute("pollStat",new PollStat());
		model.addAttribute("statList", statList);
		
		return "index";

	}
	@PostMapping("/addQuestion")
	public String questionChoice(Model model,@ModelAttribute PollStat pollStat) {
		System.out.println("Got here");
	
		statList.add(pollStat);
		model.addAttribute("statList", statList);
		model.addAttribute("pollStat",pollStat);
		
		
		
		return "index";
		
	}	
}