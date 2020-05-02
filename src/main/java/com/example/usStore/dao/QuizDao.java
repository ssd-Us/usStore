package com.example.usStore.dao;

import java.util.List;
import org.springframework.dao.DataAccessException;
import com.example.usStore.domain.Quiz;

public interface QuizDao {

	// ��ü ���� ����Ʈ ��ȯ�ϴ� �޼ҵ�
	List<Quiz> getQuizList() throws DataAccessException;
	
	// ���� ����Ʈ �� �������� �ϳ��� ��� �̾� ��ȯ�ϴ� �޼ҵ�
	Quiz getRandomQuiz(List<Quiz> quizList) throws DataAccessException;
	
	// ����ڰ� �Է��� ���� �������� �Ǻ��ϴ� �޼ҵ�
	boolean isCorrect(String quiz_id, String answer) throws DataAccessException;
}
