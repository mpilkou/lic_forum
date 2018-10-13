package ug.edu.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import ug.edu.entity.Message;
import ug.edu.service.MessageService;

@Controller
@RequestMapping("/chat")
public class ChatController {
	
	// add inject service
	@Autowired
	private MessageService messageService; 
	
	@RequestMapping("/themes")
	private String listMessages(Model model) {
		// get
		List<Message> messages = messageService.getMessages();
		
		Message message = new Message();
		// add to model
		model.addAttribute("message", message);
		model.addAttribute("messages", messages);
		
		return "messages-list";
	}
	
	@PostMapping("/addMessage")
	private String addMessage(@ModelAttribute("message") Message message) {
		
		// save obj
		try {
			message.setTopics_id(1);
			messageService.addMessage(message);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "redirect:/chat/themes";
	}
	
	@RequestMapping("/toScores")
	private String toScores() {
		return "redirect:/scores/scores";
	}
}
