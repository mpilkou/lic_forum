package ug.edu.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import ug.edu.entity.Topic;
import ug.edu.service.TopicService;

@Controller
@RequestMapping("/forum")
public class ForumController {
	
	// add inject service
	@Autowired
	private TopicService topicService; 
	
	
//	@GetMapping("/themes")
	@RequestMapping("/themes")
	private String listTopics(Model model) {
		
		// get
		List<Topic> topics = topicService.getTopics();
		
		// add to model
		model.addAttribute("topics",topics);
		
		return "topics-list";
	}
	
	@GetMapping("/addTopicForm")
	private String addTopicForm(Model model) {
		
		Topic topic = new Topic();
		
		model.addAttribute("topic", topic);
		
		return "topic-form";
	}
	
	@PostMapping("/addTopic")
	private String saveTopic(@ModelAttribute("topic") Topic topic) {
		
		// save obj
		topicService.addTopic(topic);
		
		return "redirect:/forum/themes";
	}
	
	@RequestMapping("/toScores")
	private String toScores() {
		return "redirect:/scores/scores";
	}
	
}
