package ug.edu.service;

import java.util.List;

import ug.edu.entity.Message;

public interface MessageService {
	
	public List<Message> getMessages();

	public void addMessage(Message message);
	
}
