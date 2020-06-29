package com.example.usStore.domain;

import java.io.Serializable;

/*
 * Event - Quiz Domain Class
 * */
@SuppressWarnings("serial")
public class Quiz  implements Serializable {
	
	private String quizId;		// Sequence
	private String question;	// 퀴즈 질문
	private String answer;		// 퀴즈 답
	private String hint;		// 퀴즈 힌트
	private int catId; 		//(FK) catId
	
	public Quiz() {
		
	}
	
	// getter & setter
	public String getquizId() {
		return quizId;
	}
	public void setquizId(String quizId) {
		this.quizId = quizId;
	}
	public String getQuestion() {
		return question;
	}
	public void setQuestion(String question) {
		this.question = question;
	}
	public String getAnswer() {
		return answer;
	}
	public void setAnswer(String answer) {
		this.answer = answer;
	}
	public String getHint() {
		return hint;
	}
	public void setHint(String hint) {
		this.hint = hint;
	}

	public int getCatId() {
		return catId;
	}

	public void setCatId(int catId) {
		this.catId = catId;
	}
	
}
