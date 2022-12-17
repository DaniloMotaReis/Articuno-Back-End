package br.com.articuno.model;

import java.util.Calendar;

import org.hibernate.annotations.CreationTimestamp;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "reactions")
public class Reactions {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int idReaction;
	@ManyToOne
	private Posts post;
	@ManyToOne
	private User user;
	@CreationTimestamp
	private Calendar dtReaction;
	private Boolean tpReaction;
	public int getIdReaction() {
		return idReaction;
	}
	public void setIdReaction(int idReaction) {
		this.idReaction = idReaction;
	}
	public Posts getPost() {
		return post;
	}
	public void setPost(Posts post) {
		this.post = post;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public Calendar getDtReaction() {
		return dtReaction;
	}
	public void setDtReaction(Calendar dtReaction) {
		this.dtReaction = dtReaction;
	}
	public Boolean getTpReaction() {
		return tpReaction;
	}
	public void setTpReaction(Boolean tpReaction) {
		this.tpReaction = tpReaction;
	}
	public Reactions() {
		
	}
	public Reactions(Posts post, User user, Boolean tpreaction) {
		super();
		this.post = post;
		this.user = user;
		this.tpReaction = tpreaction;
	}

}
