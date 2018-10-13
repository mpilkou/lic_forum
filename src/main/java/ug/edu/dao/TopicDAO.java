package ug.edu.dao;

import java.util.List;

import ug.edu.entity.Topic;

public interface TopicDAO {

	public List<Topic> getTopics();

	public void addTopic(Topic topic);
}
