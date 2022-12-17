package br.com.articuno.model;

import java.sql.Time;

import org.hibernate.annotations.CreationTimestamp;
import org.springframework.lang.NonNull;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "posts")
public class Posts {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int idPost;
	@ManyToOne
	private User user;
	@CreationTimestamp
	private Time dtPost;
	@NonNull
	private String post;
	public int getIdPost() {
		return idPost;
	}
	public void setIdPost(int idPost) {
		this.idPost = idPost;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public Time getDtPost() {
		return dtPost;
	}
	public void setDtPost(Time dtPost) {
		this.dtPost = dtPost;
	}
	public String getPost() {
		return post;
	}
	public void setPost(String post) {
		this.post = post;
	}
	public Posts() {
		
	}
	public Posts(User user, String post) {
		this.user = user;
		this.post = post;
	}
}
