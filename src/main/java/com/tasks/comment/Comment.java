package com.tasks.comment;

import java.sql.Timestamp;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.tasks.task.Task;
import com.tasks.user.User;

@Entity
@Table(name="comment")
public class Comment {
	
	@Id
	@GeneratedValue(strategy =  GenerationType.IDENTITY)
	private Long commentId;
	
	private String commText;
	private Timestamp createdAt;

	@ManyToOne
	@JoinColumn(name = "task_id")
	@JsonIgnore
	private Task task;
	
	@ManyToOne
	@JoinColumn(name= "user_id")
	@JsonIgnore
	private User user;
	
	public Comment(Long commentId, String commText, Task task, User user) {		
		this.commentId = commentId;
		this.commText = commText;
		this.task = task;
		this.user = user;
	}

	public Comment() {
		// TODO Auto-generated constructor stub
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

	public Task getTask() {
		return task;
	}

	public void setTask(Task task) {
		this.task = task;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
}
