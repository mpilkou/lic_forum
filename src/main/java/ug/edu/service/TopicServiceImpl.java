package ug.edu.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ug.edu.dao.TopicDAO;
import ug.edu.entity.Topic;

@Service
public class TopicServiceImpl implements TopicService {
	
	// inject DAO
	@Autowired
	private TopicDAO topicDAO;
	
	@Override
	@Transactional
	public List<Topic> getTopics() {
		return topicDAO.getTopics();
	}

	@Override
	@Transactional
	public void addTopic(Topic topic) {
		topicDAO.addTopic(topic);
	}

}
