package com.shunya.overflow.Models;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name="questions")
public class Question {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	private String qtext;
	@Transient
	private String frontEndTags;
	
	@OneToMany(mappedBy="quest", cascade=CascadeType.ALL, fetch=FetchType.LAZY)
	private List<Answer> answers;
	
	 @ManyToMany(fetch = FetchType.LAZY)
	 @JoinTable(
		name = "question_tag", 
	    joinColumns = @JoinColumn(name = "question_id"), 
	    inverseJoinColumns = @JoinColumn(name = "tag_id")
	 )
	 private List<Tag> qtags;

	public Question() {
		
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getQtext() {
		return qtext;
	}

	public void setQtext(String qtext) {
		this.qtext = qtext;
	}

	public String getFrontEndTags() {
		return frontEndTags;
	}

	public void setFrontEndTags(String frontEndTags) {
		this.frontEndTags = frontEndTags;
	}

	public List<Answer> getAnswers() {
		return answers;
	}

	public void setAnswers(List<Answer> answers) {
		this.answers = answers;
	}

	public List<Tag> getQtags() {
		return qtags;
	}

	public void setQtags(List<Tag> qtags) {
		this.qtags = qtags;
	}
	
	
	 
	 
	
}