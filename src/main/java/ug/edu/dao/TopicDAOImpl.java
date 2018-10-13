package ug.edu.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import ug.edu.entity.Topic;

@Repository
public class TopicDAOImpl implements TopicDAO {
	
	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public List<Topic> getTopics() {
		
		// get session
		Session session = sessionFactory.getCurrentSession();
		
		// new query
		Query<Topic> query = session.
				createQuery("from Topic order by date desc", Topic.class);
		
		// execute
		List<Topic> topics = query.getResultList();
		
		return topics;
	}



	@Override
	public void addTopic(Topic topic) {
		
		// get session
		Session session = sessionFactory.getCurrentSession();
		
		// save
		session.save(topic);
	}
	
	
	
	
}
