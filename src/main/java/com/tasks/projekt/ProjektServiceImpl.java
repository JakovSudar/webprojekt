package com.tasks.projekt;

import java.sql.Timestamp;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tasks.exception.CustomException;
import com.tasks.mappers.ProjektToProjektDtoMapper;
import com.tasks.payload.dto.ProjektDto;
import com.tasks.user.User;
import com.tasks.user.UserDAO;

@Service
public class ProjektServiceImpl implements ProjektService {

	@Autowired
	private ProjektDAO projektDao;
	
	@Autowired
	private UserDAO userDao;
	
	@Override
	public ProjektDto getById(Long id) {
		return new ProjektToProjektDtoMapper().map(projektDao.getById(id));
	}

	@Override
	public ProjektDto save(Projekt projekt, Long ownerId) {
		User owner = userDao.findById(ownerId).get();
		projekt.setOwner(owner);
		projekt.setCreatedAt(new Timestamp(System.currentTimeMillis()));
		return new ProjektToProjektDtoMapper().map(projektDao.save(projekt));
	}

	@Override
	public ProjektDto update(Projekt projekt, Long ownerId) throws Exception {
		Projekt temp = projektDao.getById(projekt.getProjektId());
		if(temp==null) {
			throw new CustomException("Ne postoji taj projekt.");
		}
		if(temp.getOwner().getUserId() != ownerId) {
			throw new CustomException("Niste vlasnik posla.");
		}
		temp.setNaziv(projekt.getNaziv());
		projektDao.update(temp);
		return new ProjektToProjektDtoMapper().map(temp);
	}

	
	@Override
	public void delete(Long idProjekta, Long ownerId) throws Exception{
		Projekt temp = projektDao.getById(idProjekta);
		if(temp==null) {
			throw new CustomException("Ne postoji taj projekt.");
		}
		if(temp.getOwner().getUserId() != ownerId) {
			throw new CustomException("Niste vlasnik posla.");
		}
		projektDao.delete(temp);		
	}

	@Override
	public void addWokrers(List<Long> workerIds,Long projektId) {		
		projektDao.addWorkers(workerIds ,projektId);
		
	}

	@Override
	public void addWokrersEmails(List<String> emails, Long projektId, Long userId) throws Exception {
		Projekt temp = projektDao.getById(projektId);
		if(temp==null) {
			throw new CustomException("Ne postoji taj projekt.");
		}
		if(userId!=temp.getOwner().getUserId()) {
			throw new CustomException("Samo vlasnik projekta može dodavati radnike");
		}
		
		projektDao.addWorkersEmails(emails ,temp);
		
	}

	@Override
	public void removeWorkersEmail(List<String> emails, Long projektId, Long userId) throws Exception {
		Projekt temp = projektDao.getById(projektId);
		if(temp==null) {
			throw new CustomException("Ne postoji taj projekt.");
		}
		if(userId!=temp.getOwner().getUserId()) {
			throw new CustomException("Samo vlasnik projekta može dodavati radnike");
		}
		
		projektDao.removeWorkersEmail(emails ,temp);
		
	}
}
