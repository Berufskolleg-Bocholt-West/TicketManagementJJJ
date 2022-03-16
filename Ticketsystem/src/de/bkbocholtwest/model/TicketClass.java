package de.bkbocholtwest.model;

import java.sql.Date;
import java.util.UUID;

public class TicketClass {
	
	private String ticketID;
	private String description;
	private String title;
	String[] status = {"pending", "ongoing", "qualityAssurance", "done"};
	private User editor;
	private User creator;
	private Date createdDate;
	private CommentSection comments;
	
	public TicketClass() {
		
	}
	

/*	public TicketClass(String ticketID ,String description, String title, String status[], User editor, User creator,
			Date createdDate, CommentSection comments) {
		this.ticketID = generateTicketID();
		this.description = description;
		this.title = title;
		this.status = status;
		this.editor = editor;
		this.creator = creator;
		this.createdDate = createdDate;
		this.comments = comments;
	}*/
	
	

	public static String generateTicketID() {
		String ticketID = UUID.randomUUID().toString();
		return ticketID;
	}


	public TicketClass(String ticketID, String description, String title) {
	this.ticketID = ticketID;
	this.description = description;
	this.title = title;
	}
	
	public String toString() {
		return title+": "+description;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String[] getStatus() {
		return status;
	}

	public void setStatus(String[] status) {
		this.status = status;
	}

	public User getEditor() {
		return editor;
	}

	public void setEditor(User editor) {
		this.editor = editor;
	}

	public User getCreator() {
		return creator;
	}

	public void setCreator(User creator) {
		this.creator = creator;
	}

	public Date getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

	public CommentSection getComments() {
		return comments;
	}

	public void setComments(CommentSection comments) {
		this.comments = comments;
	}

	public void showCommentSection() {
		
	}
	
	public void createComments() {
		
	}
	
	public void deleteTicket() {
		
	}

	
}
