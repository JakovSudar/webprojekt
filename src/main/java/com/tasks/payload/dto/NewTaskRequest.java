package com.tasks.payload.dto;

import java.sql.Timestamp;
import java.util.List;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class NewTaskRequest {
	
	@NotBlank(message = "Naslov zadatka je obavezan")	
	private String title;
	
	@NotBlank(message = "Opis zadatka je obavezan")	
	private String description;
	
	private Long priority;
	private Timestamp endDate;
	
	@NotNull(message = "projektId je obavezan podatak")	
	private Long projektId;
	
	@NotNull(message = "Status zadatka je obavezan")	
	private Long statusId;
	private List<Long> assignedUsersIDs;	
	
	public NewTaskRequest(String title, String description, Long priority, Timestamp endDate, Long projektId,
			Long statusId, List<Long> assignedUsersIDs) {		
		this.title = title;
		this.description = description;
		this.priority = priority;
		this.endDate = endDate;
		this.projektId = projektId;
		this.statusId = statusId;
		this.assignedUsersIDs = assignedUsersIDs;
	}	
	
	public NewTaskRequest() {		
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
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
	public Timestamp getEndDate() {
		return endDate;
	}
	public void setEndDate(Timestamp endDate) {
		this.endDate = endDate;
	}
	public Long getProjektId() {
		return projektId;
	}
	public void setProjektId(Long projektId) {
		this.projektId = projektId;
	}
	public Long getStatusId() {
		return statusId;
	}
	public void setStatusId(Long statusId) {
		this.statusId = statusId;
	}
	public List<Long> getAssignedUsersIDs() {
		return assignedUsersIDs;
	}
	public void setAssignedUsersIDs(List<Long> assignedUsersIDs) {
		this.assignedUsersIDs = assignedUsersIDs;
	}
	
	


}
