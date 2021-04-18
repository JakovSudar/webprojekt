package com.tasks.taskstatus;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GeneratorType;

@Entity
@Table(name = "task_status")
public class TaskStatus {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long statusId;
	
	private String title;

	public TaskStatus() {
		
	}
	
	public TaskStatus(Long statusId, String title) {
		super();
		this.statusId = statusId;
		this.title = title;
	}

	public Long getStatusId() {
		return statusId;
	}

	public void setStatusId(Long statusId) {
		this.statusId = statusId;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}
	
	
	

}
