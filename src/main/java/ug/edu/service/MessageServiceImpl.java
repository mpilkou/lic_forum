package ug.edu.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ug.edu.dao.MessageDAO;
import ug.edu.entity.Message;



@Service
public class MessageServiceImpl implements MessageService {
	
	// inject DAO
	@Autowired
	private MessageDAO messageDAO;
	
	@Override
	@Transactional
	public List<Message> getMessages() {
		
		return messageDAO.getMessages();
	}

	@Override
	@Transactional
	public void addMessage(Message message) {
		messageDAO.addMessage(message);
	}

}
