package com.tasks.task;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.tasks.comment.Comment;
import com.tasks.projekt.Projekt;
import com.tasks.taskstatus.TaskStatus;
import com.tasks.user.User;

@Entity
@Table(name="task")
public class Task {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long taskId;
	
	@ManyToOne
	@JoinColumn(name="owner_id")
	@JsonIgnore
	private User owner;
	
	private String title;
	private String description;
	private Long priority;
	
	
	@ManyToOne
	@JoinColumn(name = "status")
	private TaskStatus status;
	
	@ManyToOne
	@JoinColumn(name = "projekt_id")
	@JsonIgnore
	private Projekt projekt;
	
	@ManyToMany
	@JoinTable(name="task_assigns", joinColumns = @JoinColumn(name="task_id"),
	inverseJoinColumns = @JoinColumn(name="user_id"))
	private List<User> assignedUsers;
	
	
	@OneToMany (mappedBy = "task" , cascade = CascadeType.REMOVE)	
	private List<Comment> comments;
	
	private Timestamp createdAt;
	private Timestamp endDate;
	
	
	
	public void addAssignedUsers(List<User> users) {
		this.assignedUsers = Stream.concat(assignedUsers.stream(), users.stream()).collect(Collectors.toList());
	}
	
	public void addAssignedUser(User user) {
		if(this.assignedUsers==null) {
			this.assignedUsers = new ArrayList<User>();
		}
		this.assignedUsers.add(user);
	}
	public void removeAssignedUser(User user) {
		this.assignedUsers.remove(user);
	}
	
	public Task() {
		
	}
	
	
	
	
	public Task(Long taskId, User owner, String title, String description, Long priority, TaskStatus status,
			Projekt projekt, List<User> assignedUsers, Timestamp createdAt, Timestamp endDate) {
	
		this.taskId = taskId;
		this.owner = owner;
		this.title = title;
		this.description = description;
		this.priority = priority;
		this.status = status;
		this.projekt = projekt;
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
	public User getOwner() {
		return owner;
	}
	public void setOwner(User owner) {
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
	public Projekt getProjekt() {
		return projekt;
	}
	public void setProjekt(Projekt projekt) {
		this.projekt = projekt;
	}
	public List<User> getAssignedUsers() {
		return assignedUsers;
	}
	public void setAssignedUsers(List<User> assignedUsers) {
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

	public List<Comment> getComments() {
		return comments;
	}

	public void setComments(List<Comment> comments) {
		this.comments = comments;
	}
	
	
	
	
}
