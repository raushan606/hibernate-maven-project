package com.map;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Entity
public class Question {

	@Id
	// @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "question_id")
	private int qid;

	private String question;
	
	@OneToOne
	@JoinColumn(name = "aid")
	private Answer answer;

	public Question() {
		super();

	}

	public Question(int qid, String question, Answer answer) {
		super();
		this.qid = qid;
		this.question = question;
		this.answer = answer;
	}

	public int getQid() {
		return qid;
	}

	public void setQid(int qid) {
		this.qid = qid;
	}

	public String getQuestion() {
		return question;
	}

	public void setQuestion(String question) {
		this.question = question;
	}

	public Answer getAnswer() {
		return answer;
	}

	public void setAnswer(Answer answer) {
		this.answer = answer;
	}

}
