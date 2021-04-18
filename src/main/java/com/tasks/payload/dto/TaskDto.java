package com.tasks.payload.dto;

import java.sql.Timestamp;
import java.util.List;

import com.tasks.projekt.Projekt;

import com.tasks.taskstatus.TaskStatus;


public class TaskDto{	

	private String title;
	private Long taskId;		
	private String description;
	private Long priority;		
	private Timestamp createdAt;
	private Timestamp endDate;
	private TaskStatus status;	
	private UserDto owner;	
	private List<UserDto> assignedUsers;		
	
	public TaskDto() {		
	}
	public TaskDto(Long taskId, UserDto owner, String description, Long priority, TaskStatus status, 
			List<UserDto> assignedUsers, Timestamp createdAt, Timestamp endDate) {
		super();
		this.taskId = taskId;
		this.owner = owner;
		this.description = description;
		this.priority = priority;
		this.status = status;
		
		this.assignedUsers = assignedUsers;
		this.createdAt = createdAt;
		this.endDate = endDate;
	}
	
	
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public Long getTaskId() {
		return taskId;
	}
	public void setTaskId(Long taskId) {
		this.taskId = taskId;
	}
	public UserDto getOwner() {
		return owner;
	}
	public void setOwner(UserDto owner) {
		this.owner = owner;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Long getPriority() {
		return priority;
	}
	public void setPriority(Long priority) {
		this.priority = priority;
	}
	public TaskStatus getStatus() {
		return status;
	}
	public void setStatus(TaskStatus status) {
		this.status = status;
	}	
	public List<UserDto> getAssignedUsers() {
		return assignedUsers;
	}
	public void setAssignedUsers(List<UserDto> assignedUsers) {
		this.assignedUsers = assignedUsers;
	}
	public Timestamp getCreatedAt() {
		return createdAt;
	}
	public void setCreatedAt(Timestamp createdAt) {
		this.createdAt = createdAt;
	}
	public Timestamp getEndDate() {
		return endDate;
	}
	public void setEndDate(Timestamp endDate) {
		this.endDate = endDate;
	}
	
	
}
