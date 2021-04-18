package com.tasks.mappers;

import java.util.ArrayList;
import java.util.List;

import com.tasks.payload.dto.ProjektDto;
import com.tasks.payload.dto.UserDto;
import com.tasks.projekt.Projekt;

public class ProjektToProjektDtoMapper {
	
	public ProjektDto map(Projekt p) {
		ProjektDto mappedProjekt = new ProjektDto();
		UserDto tempOwner = new UserToUserDtoMapper().map(p.getOwner());
		List<UserDto> tempAssigned = new ArrayList<UserDto>();
		if(p.getAssignedUsers()!=null) {
			p.getAssignedUsers().forEach(user ->{
				tempAssigned.add(new UserToUserDtoMapper().map(user));
			});	
		}
			
		mappedProjekt.setNaziv(p.getNaziv());
		mappedProjekt.setCreatedAt(p.getCreatedAt());
		mappedProjekt.setProjektId(p.getProjektId());
		mappedProjekt.setAssignedUsers(tempAssigned);
		mappedProjekt.setOwner(tempOwner);
		
		return mappedProjekt;
	}

}
