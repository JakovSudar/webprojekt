package com.tasks.mappers;

import java.util.ArrayList;
import java.util.List;

import com.tasks.payload.dto.UserDto;
import com.tasks.user.User;

public class UserToUserDtoMapper {

	public UserDto map(User user) {
		
		UserDto temp = new UserDto();
		temp.setUserId(user.getUserId());
		temp.setEmail(user.getEmail());
		temp.setAuthProvider(user.getAuthProvider());		
		temp.setImgUrl(user.getImgUrl());		
		temp.setUsername(user.getUsername());
		temp.setTstampReg(user.getTstampReg());		
		return temp;
	}	
	
	public List<UserDto> mapList(List<User>users){
		List<UserDto> mapped = new ArrayList<UserDto>();
		if(users!=null) {			
			for (User user : users) {
				mapped.add(map(user));
			}			
		}
		return mapped;
	}

}
