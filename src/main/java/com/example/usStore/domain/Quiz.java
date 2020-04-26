package com.example.usStore.domain;

/*
 * Event Function - Quiz
 * */
public class Quiz {
	
	private String quiz_id;		// ÄûÁîÀÇ id
	private String question;	// ÄûÁî Áú¹®
	private String answer;		// ÄûÁî ´ä
	private String hint;		// ÄûÁî¿¡ ´ëÇÑ ÈùÆ®
	
	// ±âº» »ı¼ºÀÚ
	public Quiz() {
		
	}
	
	// getter & setter
	public String getQuiz_id() {
		return quiz_id;
	}
	public void setQuiz_id(String quiz_id) {
		this.quiz_id = quiz_id;
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
}
