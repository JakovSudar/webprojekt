package com.tasks.payload.dto;

import javax.persistence.Entity;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;


public class CommentRequest {
	
	private Long commentId;
	
	@NotBlank(message = "Sadržaj komentara je obavezan")	
	private String comment;
	
	
	@NotNull(message = "Id zadatka je obavezan")
	private Long taskId;
	
	
	
	public CommentRequest(Long commentId, String comment, Long taskId) {		
		this.commentId = commentId;
		this.comment = comment;
		this.taskId = taskId;
	}
	public Long getCommentId() {
		return commentId;
	}
	public void setCommentId(Long commentId) {
		this.commentId = commentId;
	}
	public String getComment() {
		return comment;
	}
	public void setComment(String comment) {
		this.comment = comment;
	}
	public Long getTaskId() {
		return taskId;
	}
	public void setTaskId(Long taskId) {
		this.taskId = taskId;
	}
	
	
}
