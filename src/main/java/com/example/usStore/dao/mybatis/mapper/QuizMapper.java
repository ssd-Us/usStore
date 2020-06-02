package com.example.usStore.dao.mybatis.mapper;

import java.util.List;

import org.springframework.dao.DataAccessException;

import com.example.usStore.domain.Quiz;

public interface QuizMapper {

	// 전체 퀴즈 리스트 반환하는 메소드
<<<<<<< HEAD
	List<Quiz> getQuizList();

	// 퀴즈 리스트 중 랜덤으로 하나의 퀴즈를 뽑아 반환하는 메소드
	Quiz getRandomQuiz(List<Quiz> quizList);

	// 사용자가 입력한 값이 정답인지 판별하는 메소드
	boolean isCorrect(String quizId, String answer);
=======
	List<Quiz> getQuizList() throws DataAccessException;

	// 퀴즈 리스트 중 랜덤으로 하나의 퀴즈를 뽑아 반환하는 메소드
	Quiz getRandomQuiz(List<Quiz> quizList) throws DataAccessException;

	// 사용자가 입력한 값이 정답인지 판별하는 메소드
	boolean isCorrect(String quizId, String answer) throws DataAccessException;
>>>>>>> branch 'test' of https://github.com/ssd-Us/usStore.git
}
