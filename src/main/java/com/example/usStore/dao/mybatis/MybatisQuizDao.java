package com.example.usStore.dao.mybatis;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;

import com.example.usStore.dao.AccountDao;
import com.example.usStore.dao.QuizDao;
import com.example.usStore.dao.mybatis.mapper.QuizMapper;
import com.example.usStore.domain.Quiz;

@Repository
public class MybatisQuizDao implements QuizDao {

	@Autowired
	private QuizMapper quizMapper;
	
	@Override
	public List<Quiz> getQuizList() throws DataAccessException {
		// TODO Auto-generated method stub
		return quizMapper.getQuizList();
	}

	@Override
	public Quiz getRandomQuiz(List<Quiz> quizList) throws DataAccessException {
		// TODO Auto-generated method stub
		return quizMapper.getRandomQuiz(quizList);
	}

	@Override
	public boolean isCorrect(String quizId, String answer) throws DataAccessException {
		// TODO Auto-generated method stub
		return quizMapper.isCorrect(quizId, answer);
	}

}
