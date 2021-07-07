package com.tasks.payload.dto;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.tasks.user.User;

public class ProjektDto {
	
	
	private Long projektId;	
	private String naziv;
	private Timestamp createdAt;	
	private UserDto owner;	
	private List<UserDto> assignedUsers;
	private List<TaskDto> tasks;
	
	
	public void addAssignedUsers(List<UserDto> users) {
		this.assignedUsers = Stream.concat(assignedUsers.stream(), users.stream()).collect(Collectors.toList());
	}
	
	public void addAssignedUser(UserDto user) {
		if(this.assignedUsers==null) {
			this.assignedUsers = new ArrayList<UserDto>();
		}
		this.assignedUsers.add(user);
	}

	

	public ProjektDto(Long projektId, String naziv, Timestamp createdAt, UserDto owner, List<UserDto> assignedUsers,
			List<TaskDto> tasks) {
		super();
		this.projektId = projektId;
		this.naziv = naziv;
		this.createdAt = createdAt;
		this.owner = owner;
		this.assignedUsers = assignedUsers;
		this.tasks = tasks;
	}

	public ProjektDto() {
		
	}

	

	public Long getProjektId() {
		return projektId;
	}

	public void setProjektId(Long projektId) {
		this.projektId = projektId;
	}

	public String getNaziv() {
		return naziv;
	}

	public void setNaziv(String naziv) {
		this.naziv = naziv;
	}

	public Timestamp getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Timestamp createdAt) {
		this.createdAt = createdAt;
	}

	public UserDto getOwner() {
		return owner;
	}

	public void setOwner(UserDto owner) {
		this.owner = owner;
	}

	public List<UserDto> getAssignedUsers() {
		return assignedUsers;
	}

	public void setAssignedUsers(List<UserDto> assignedUsers) {
		this.assignedUsers = assignedUsers;
	}

	public List<TaskDto> getTasks() {
		return tasks;
	}

	public void setTasks(List<TaskDto> tasks) {
		this.tasks = tasks;
	}
	
	

}
