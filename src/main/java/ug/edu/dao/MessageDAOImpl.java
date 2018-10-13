package ug.edu.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import ug.edu.entity.Message;

@Repository
public class MessageDAOImpl implements MessageDAO {
	
	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public List<Message> getMessages() {
		
		// get session
		Session session = sessionFactory.getCurrentSession();
		
		// new query
		Query<Message> query = session.
				createQuery("from Message order by date desc", Message.class);
		
		// execute
		List<Message> message = query.getResultList();
		
		return message;
	}



	@Override
	public void addMessage(Message message) {
		
		// get session
		Session session = sessionFactory.getCurrentSession();
		
		// save
		session.save(message);
	}
	
	
	
	
}
