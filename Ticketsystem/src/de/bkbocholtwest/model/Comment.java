package de.bkbocholtwest.model;

import java.sql.Date;
import java.util.ArrayList;

public class Comment {
	private int commentID;
	ArrayList<Comment> answers = new ArrayList<Comment>();
	private User creator;
	private Date date;
	private String content;
	
	
	public Comment() {
		
	}
	
	
	public Comment(int commentID, ArrayList<Comment> answers, User creator, Date date, String content) {
		this.commentID = commentID;
		this.answers = answers;
		this.creator = creator;
		this.date = date;
		this.content = content;
	}


	public int getCommentID() {
		return commentID;
	}
	public void setCommentID(int commentID) {
		this.commentID = commentID;
	}
	public ArrayList<Comment> getAnswers() {
		return answers;
	}
	public void setAnswers(ArrayList<Comment> answers) {
		this.answers = answers;
	}
	public User getCreator() {
		return creator;
	}
	public void setCreator(User creator) {
		this.creator = creator;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	
	
	
}
