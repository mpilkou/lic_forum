package ug.edu.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ug.edu.dao.ScoreDAO;
import ug.edu.entity.Score;

@Service
public class ScoreServiceImpl implements ScoreService {
	
	// inject DAO
	@Autowired
	private ScoreDAO scoreDAO;
	
	@Override
	@Transactional
	public List<Score> getScores() {
		
		return scoreDAO.getScores();
	}
}
