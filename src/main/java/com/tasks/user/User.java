package com.tasks.user;


import java.sql.Timestamp;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.tasks.comment.Comment;
import com.tasks.model.AuthProvider;
import com.tasks.notification.Notification;
import com.tasks.projekt.Projekt;
import com.tasks.task.Task;

@Entity
@Table(name = "korisnik")
public class User {
						
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long userId;
	
	private String password;
	@Enumerated(EnumType.STRING)
	private AuthProvider authProvider;
	private Timestamp tstampReg;
	private String imgUrl;
	private Boolean enabled;
	private int oznAkt;
	private String username;
	private String email;
	
	@OneToMany (mappedBy = "owner" , cascade = CascadeType.REMOVE)	
	private List<Projekt> ownProjects;
	
	@OneToMany(mappedBy = "user")
	private List<Notification> notifications;	
	
	@ManyToMany	
	@JoinTable(name ="projekt_assigns", joinColumns = @JoinColumn(name="user_id"), inverseJoinColumns = @JoinColumn(name="projekt_id"))
	private List<Projekt> assignedProjects;
	
	@ManyToMany
	@JoinTable(name="task_assigns", inverseJoinColumns  = @JoinColumn(name="user_id"),
			joinColumns = @JoinColumn(name="task_id"))
	
	
	@JsonIgnore
	private List<Task> taskovi;	
	
	@Transient
	private String providerIdString;	
	
	public User() {
		super();		
	}
	public User(Long userId, String password, AuthProvider authProvider, Timestamp tstampReg, String imgUrl,
			Boolean enabled, int oznAkt, String username, String email, List<Projekt> ownProjects,
			List<Projekt> assignedProjects, List<Task> taskovi, List<Notification> notifications,
			String providerIdString) {		
		this.userId = userId;
		this.password = password;
		this.authProvider = authProvider;
		this.tstampReg = tstampReg;
		this.imgUrl = imgUrl;
		this.enabled = enabled;
		this.oznAkt = oznAkt;
		this.username = username;
		this.email = email;
		this.ownProjects = ownProjects;
		this.assignedProjects = assignedProjects;
		this.taskovi = taskovi;
		this.notifications = notifications;
		this.providerIdString = providerIdString;
	}

	public List<Task> getTaskovi() {
		return taskovi;
	}

	public void setTaskovi(List<Task> taskovi) {
		this.taskovi = taskovi;
	}

	public List<Notification> getNotifications() {
		return notifications;
	}

	public void setNotifications(List<Notification> notifications) {
		this.notifications = notifications;
	}

	public Long getUserId() {
		return userId;
	}


	public void setUserId(Long userId) {
		this.userId = userId;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}


	public AuthProvider getAuthProvider() {
		return authProvider;
	}


	public void setAuthProvider(AuthProvider authProvider) {
		this.authProvider = authProvider;
	}


	public Timestamp getTstampReg() {
		return tstampReg;
	}


	public void setTstampReg(Timestamp tstampReg) {
		this.tstampReg = tstampReg;
	}


	public String getImgUrl() {
		return imgUrl;
	}


	public void setImgUrl(String imgUrl) {
		this.imgUrl = imgUrl;
	}


	public Boolean getEnabled() {
		return enabled;
	}


	public void setEnabled(Boolean enabled) {
		this.enabled = enabled;
	}


	public int getOznAkt() {
		return oznAkt;
	}


	public void setOznAkt(int oznAkt) {
		this.oznAkt = oznAkt;
	}


	public String getUsername() {
		return username;
	}


	public void setUsername(String username) {
		this.username = username;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public List<Projekt> getOwnProjects() {
		return ownProjects;
	}


	public void setOwnProjects(List<Projekt> ownProjects) {
		this.ownProjects = ownProjects;
	}


	public List<Projekt> getAssignedProjects() {
		return assignedProjects;
	}


	public void setAssignedProjects(List<Projekt> assignedProjects) {
		this.assignedProjects = assignedProjects;
	}


	public String getProviderIdString() {
		return providerIdString;
	}


	public void setProviderIdString(String providerIdString) {
		this.providerIdString = providerIdString;
	}
	
	
	
	
	
	
}