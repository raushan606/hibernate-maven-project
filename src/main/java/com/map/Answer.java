package com.map;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

@Entity
public class Answer {

	@Id
	// @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "answer_id")
	private int aid;

	
	private String answer;
	
//	@OneToOne(mappedBy = "answer")
//	private Question q;
	

	@ManyToOne
	private Question q;

	public Question getQ() {
		return q;
	}

	public void setQ(Question q) {
		this.q = q;
	}

	public Answer() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Answer(int aid, String answer) {
		super();
		this.aid = aid;
		this.answer = answer;
	}

	public int getAid() {
		return aid;
	}

	public void setAid(int aid) {
		this.aid = aid;
	}

	public String getAnswer() {
		return answer;
	}

	public void setAnswer(String answer) {
		this.answer = answer;
	}

}
