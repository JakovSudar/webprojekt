package com.tasks.payload.dto;

import java.sql.Timestamp;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;

import com.tasks.model.AuthProvider;

public class UserDto {
	
	private Long userId;	
	private AuthProvider authProvider;
	private Timestamp tstampReg;
	private String imgUrl;	
	private String username;
	private String email;	
	
	public UserDto() {
		
	}	
	
	public UserDto(Long userId,AuthProvider authProvider, Timestamp tstampReg, String imgUrl,
			 String username, String email) {
		super();
		this.userId = userId;		
		this.authProvider = authProvider;
		this.tstampReg = tstampReg;
		this.imgUrl = imgUrl;		
		this.username = username;
		this.email = email;
	}


	public Long getUserId() {
		return userId;
	}
	public void setUserId(Long userId) {
		this.userId = userId;
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
	
	

}
