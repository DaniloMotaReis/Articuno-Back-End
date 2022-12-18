package br.com.articuno.model;

import java.sql.Time;

import org.hibernate.annotations.CreationTimestamp;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "answer")
public class Answer {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int idAnswer;
	private String answer;
	@ManyToOne
	private User user;
	@ManyToOne
	private Posts post;
	@CreationTimestamp
	private Time dtAnswer;
	public int getIdAnswer() {
		return idAnswer;
	}
	public void setIdAnswer(int idAnswer) {
		this.idAnswer = idAnswer;
	}
	public String getAnswer() {
		return answer;
	}
	public void setAnswer(String answer) {
		this.answer = answer;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public Posts getPost() {
		return post;
	}
	public void setPost(Posts post) {
		this.post = post;
	}
	public Time getDtAnswer() {
		return dtAnswer;
	}
	public void setDtAnswer(Time dtAnswer) {
		this.dtAnswer = dtAnswer;
	}
	public Answer(){
		
	}
	public Answer(String answer, User user, Posts post){
		super();
		this.answer = answer;
		this.user = user;
	}		
}
