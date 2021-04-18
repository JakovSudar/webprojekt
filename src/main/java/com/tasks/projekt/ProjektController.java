package com.tasks.projekt;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tasks.exception.CustomException;
import com.tasks.payload.dto.ProjektDto;
import com.tasks.security.CurrentUser;
import com.tasks.security.UserPrincipal;

@RestController
@RequestMapping("/projekt")
public class ProjektController {
	
	@Autowired
	private ProjektService projektService;	
	
	@GetMapping("/{id}")
	public ProjektDto getById(@PathVariable Long id) {
		return projektService.getById(id);
	}
	
	@PostMapping()
	@Transactional
	public ProjektDto save(@RequestBody Projekt projekt, @CurrentUser UserPrincipal userPrincipal) {				
		return projektService.save(projekt,userPrincipal.getId());
	}
	
	@PutMapping()
	@Transactional
	public ProjektDto update(@RequestBody Projekt projekt, @CurrentUser UserPrincipal userPrincipal) throws Exception{		
		return projektService.update(projekt, userPrincipal.getId());
		
	}
	
	@DeleteMapping("/{projektId}")
	@Transactional
	public void delete(@PathVariable Long projektId, @CurrentUser UserPrincipal userPrincipal) throws Exception {
		projektService.delete(projektId, userPrincipal.getId());
	}
	@PostMapping("/addWorkers/{projektId}")
	@Transactional
	public void addWorkers(@RequestBody List<String> emails, @PathVariable Long projektId, @CurrentUser UserPrincipal userPrincipal) throws Exception {		
		try {
			projektService.addWokrersEmails(emails, projektId, userPrincipal.getId());
		}catch(CustomException e){
			throw e;
		}
		catch (Exception e) {
			throw e;
		}		
	}
	
	@PutMapping("/removeWorkers/{projektId}")
	@Transactional
	public void removeWorkers(@RequestBody List<String> emails, @PathVariable Long projektId, @CurrentUser UserPrincipal userPrincipal) throws Exception {		
		try {
			projektService.removeWorkersEmail(emails, projektId, userPrincipal.getId());
		}catch(CustomException e){
			throw e;
		}
		catch (Exception e) {
			throw e;
		}		
	}
	
}
