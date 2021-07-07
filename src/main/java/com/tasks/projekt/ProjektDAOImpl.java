package com.tasks.projekt;

import java.sql.Timestamp;
import java.util.List;
import java.util.Optional;

import javax.persistence.EntityManager;

import org.slf4j.LoggerFactory;
import org.slf4j.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;


import com.tasks.user.User;
import com.tasks.user.UserDAO;
import com.tasks.util.MailService;


@Repository
public class ProjektDAOImpl implements ProjektDAO {
	
	@Autowired
	private EntityManager em;
	
	@Autowired
	private UserDAO userDao;
	
	@Autowired
	private MailService mailService;
	
	@Autowired
	private JdbcTemplate jdbcTemplate;

	Logger logger = LoggerFactory.getLogger(ProjektDAO.class);

	
	@Override
	public Projekt getById(Long id) {
		return em.find(Projekt.class, id);
	}

	@Override
	public Projekt save(Projekt projekt) {
		return em.merge(projekt);
		
	}

	@Override
	public Projekt update(Projekt projekt) {
		Projekt temp = getById(projekt.getProjektId());
		temp.setNaziv(projekt.getNaziv());
		
		em.merge(temp);		
		return temp;
	}

	@Override
	public void delete(Projekt projekt) {
		em.remove(projekt);
	}

	@Override
	public void addWorkers(List<Long> workerIds, Long projektId) {
		String query = "insert into projekt_assigns values(?,?)";
		for (Long id : workerIds) {
			jdbcTemplate.update(query,new Object[] {id,projektId});
		}		
	}

	@Override
	public void addWorkersEmails(List<String> emails,  Projekt projekt) {
		logger.info("Dodajem radnike na projekt");
		for(String mail : emails) {
			Optional<User> temp = userDao.findByEmail(mail);
			if(temp.isPresent()) {
				projekt.addAssignedUser(temp.get());
				em.persist(projekt);
			}else {
				User newUser = new User();
				newUser.setEmail(mail);
				newUser.setOznAkt(0);
				newUser.setTstampReg(new Timestamp(System.currentTimeMillis()));
				em.persist(newUser);
				projekt.addAssignedUser(newUser);
				em.persist(projekt);
				try {
					mailService.sendMails(mail, "Dodani ste na projekt:"+projekt.getNaziv()+"\n Molimo vas kliknite na poveznicu kako bi se prijavili u aplikaciju. \n"
							+ " http://localhost:3000/login" , "Tasks - registracija");
				} catch (Exception e) {
					logger.error(e.toString());
				}
				
			}
		}		
	}

	@Override
	public void removeWorkersEmail(List<String> emails, Projekt projekt) {
		for(String mail : emails) {
			Optional<User> temp = userDao.findByEmail(mail);
			if(temp.isPresent()) {
				projekt.removeAssignedUser(temp.get());
				try {
					mailService.sendMails(mail, "Maknuti ste s projekta: " + projekt.getNaziv(), "Obavijest o izmjenama na projektu");
				} catch (Exception e) {
					
				}
				
			}
		}		
		
	}	
}
