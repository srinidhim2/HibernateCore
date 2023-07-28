package com.tut;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity
public class Question {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int qid;
	public List<Answer> getAns() {
		return ans;
	}
	private String question;
	@OneToMany(mappedBy = "q",fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private List<Answer> ans;
	public Question(int qid, String question, List<Answer> ans) {
		super();
		this.qid = qid;
		this.question = question;
		this.ans = ans;
	}
	public void setAns(List<Answer> ans) {
		this.ans = ans;
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
