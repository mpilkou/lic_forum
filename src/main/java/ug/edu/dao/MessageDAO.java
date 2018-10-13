package ug.edu.dao;

import java.util.List;

import ug.edu.entity.*;

public interface MessageDAO {

	public List<Message> getMessages();

	public void addMessage(Message message);
}
