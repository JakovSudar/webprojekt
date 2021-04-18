package com.tasks.notification;

import java.sql.Timestamp;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.tasks.user.User;

@Entity
@Table(name="notification")
public class Notification {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long notificationId;	
	
	private String description;
	
	private String link;
	
	private Timestamp createdAt;
	private Long status;
	
	@ManyToOne	
	@JoinColumn(name="user_id")
	@JsonIgnore
	private User user;

	

	public Notification(Long notificationId, String description, String link, Timestamp createdAt, Long status,
			User user) {
		super();
		this.notificationId = notificationId;
		this.description = description;
		this.link = link;
		this.createdAt = createdAt;
		this.status = status;
		this.user = user;
	}



	public Notification() {
		
	}
	
	

	public Long getStatus() {
		return status;
	}

	public void setStatus(Long status) {
		this.status = status;
	}

	public Long getNotificationId() {
		return notificationId;
	}

	public void setNotificationId(Long notificationId) {
		this.notificationId = notificationId;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getLink() {
		return link;
	}

	public void setLink(String link) {
		this.link = link;
	}

	public Timestamp getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Timestamp createdAt) {
		this.createdAt = createdAt;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
}
