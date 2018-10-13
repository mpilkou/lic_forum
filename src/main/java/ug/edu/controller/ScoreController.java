package ug.edu.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import ug.edu.entity.Score;
import ug.edu.service.ScoreService;

@Controller
@RequestMapping("/scores")
public class ScoreController {
	
	// add inject service
	@Autowired
	private ScoreService scoreService; 
	
	@RequestMapping("/scores")
	private String listScores(Model model) {
		
		// get
		List<Score> scores = scoreService.getScores();
		
		// add to model
		model.addAttribute("scores",scores);
		
		return "scores-list";
	}
	
	@RequestMapping("/toForum")
	private String toScores() {
		return "redirect:/forum/themes";
	}
	
}
