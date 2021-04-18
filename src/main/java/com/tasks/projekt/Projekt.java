package com.tasks.projekt;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

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
import com.tasks.task.Task;
import com.tasks.user.User;

@Entity
@Table(name="projekt")
public class Projekt {

		@Id
		@GeneratedValue(strategy = GenerationType.IDENTITY)
		private Long projektId;
		
		private String naziv;
		private Timestamp createdAt;
		
		@ManyToOne
		@JoinColumn(name="vlasnik_id")
		@JsonIgnore
		private User owner;
		
		@ManyToMany
		@JsonIgnore
		@JoinTable(name ="projekt_assigns", inverseJoinColumns = @JoinColumn(name="user_id"), joinColumns = @JoinColumn(name="projekt_id"))
		private List<User> assignedUsers;
		
		@OneToMany(mappedBy = "projekt")
		@JsonIgnore		
		private List<Task> taskovi;
		
		
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
		

		public Projekt() {			
			
		}

		public Projekt(Long projektId, String naziv, Timestamp createdAt, User owner, List<User> assignedUsers) {
			super();
			this.projektId = projektId;
			this.naziv = naziv;
			this.createdAt = createdAt;
			this.owner = owner;
			this.assignedUsers = assignedUsers;
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

		public User getOwner() {
			return owner;
		}

		public void setOwner(User owner) {
			this.owner = owner;
		}

		public List<User> getAssignedUsers() {
			return assignedUsers;
		}

		public void setAssignedUsers(List<User> assignedUsers) {
			this.assignedUsers = assignedUsers;
		} 
		
		
		
}
