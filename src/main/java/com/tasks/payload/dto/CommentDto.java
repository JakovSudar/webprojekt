package com.tasks.payload.dto;

import java.sql.Timestamp;


public class CommentDto {
	
	private Long commentId;	
	private String commText;
	private Timestamp createdAt;		
	private UserDto user;
	
	public CommentDto() {
		
	}
	
	public CommentDto(Long commentId, String commText, Timestamp createdAt, UserDto user) {		
		this.commentId = commentId;
		this.commText = commText;
		this.createdAt = createdAt;
		this.user = user;
	}

	public Long getCommentId() {
		return commentId;
	}

	public void setCommentId(Long commentId) {
		this.commentId = commentId;
	}

	public String getCommText() {
		return commText;
	}

	public void setCommText(String commText) {
		this.commText = commText;
	}

	public Timestamp getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Timestamp createdAt) {
		this.createdAt = createdAt;
	}

	public UserDto getUser() {
		return user;
	}

	public void setUser(UserDto user) {
		this.user = user;
	}	
}
