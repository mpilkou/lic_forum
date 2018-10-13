package ug.edu.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import ug.edu.entity.Score;

@Repository
public class ScoreDAOImpl implements ScoreDAO {
	
	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public List<Score> getScores() {
		
		// get session
		Session session = sessionFactory.getCurrentSession();
		
		// new query
		Query<Score> query = session.
				createQuery("from Score order by score desc", Score.class);
		
		// execute
		List<Score> scores = query.getResultList();
		
		return scores;
	}
}
