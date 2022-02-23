package de.bkbocholtwest.model;

import java.util.ArrayList;

public class CommentSection {
	
	private ArrayList<Comment> comments = new ArrayList<Comment>();

	
	public CommentSection() {
		
	}
	
	public ArrayList<Comment> getComments() {
		return comments;
	}

	public void setComments(ArrayList<Comment> comments) {
		this.comments = comments;
	}
	
	
	
}
