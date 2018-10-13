package ug.edu.service;

import java.util.List;

import ug.edu.entity.Topic;

public interface TopicService {
	
	public List<Topic> getTopics();

	public void addTopic(Topic topic);
	
}
