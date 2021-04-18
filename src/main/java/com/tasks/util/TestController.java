package com.tasks.util;

import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tasks.mappers.ProjektToProjektDtoMapper;
import com.tasks.payload.dto.ProjektDto;
import com.tasks.projekt.Projekt;
import com.tasks.projekt.ProjektDAO;
import com.tasks.user.User;
import com.tasks.user.UserDAO;

@RestController
@RequestMapping("/test")
public class TestController {
	
	@Autowired
	private UserDAO userDao;
	
	@Autowired
	private ProjektDAO projektDao;
	
	@PostMapping("/add")
	@Transactional
    public Projekt authenticateUser( @RequestBody Projekt projekt) {
		return projektDao.update(projekt);
       
    }
	@GetMapping("/get/{id}")
	@Transactional
    public ProjektDto getprojekt( @PathVariable Long id) {
		
		Projekt temp = projektDao.getById(id);
		ProjektDto res = new ProjektToProjektDtoMapper().map(temp);
		return res;
       
    }

}
