package com.tut;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class Question {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int qid;
	private String question;
	@OneToOne
	private Answer ans;
	public int getQid() {
		return qid;
	}
	public Question(int qid, String question, Answer ans) {
		super();
		this.qid = qid;
		this.question = question;
		this.ans = ans;
	}
	public Answer getAns() {
		return ans;
	}
	public void setAns(Answer ans) {
		this.ans = ans;
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
	public Question(int qid, String question) {
		super();
		this.qid = qid;
		this.question = question;
	}
	public Question() {
		super();
		// TODO Auto-generated constructor stub
	}
	
}
