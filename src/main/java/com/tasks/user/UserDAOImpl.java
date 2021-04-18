package com.tasks.user;

import java.sql.Timestamp;
import java.util.Optional;
import javax.persistence.EntityManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class UserDAOImpl implements UserDAO {

	@Autowired
	JdbcTemplate jdbcTemplate;
	
	@Autowired
	private EntityManager entityManager;
	
	@Override
	public Optional<User> findByEmail(String email) {
		try {
			User user = (User) entityManager.createQuery("select u from User u where u.email = :mail")
					.setParameter("mail", email).getSingleResult();
			return Optional.of(user);
		} catch (Exception e) {
			return Optional.empty();
		}		
	}

	@Override
	public Optional<User> findById(Long id) {	
			User user = (User) entityManager.find(User.class, id);
			return Optional.ofNullable(user);		
	}

	@Override
	public Boolean existsByEmail(String email) {
		try {
			User user = (User) entityManager.createQuery("select u from User u where u.email = :mail")
					.setParameter("mail", email).getSingleResult();
			return true;
		} catch (Exception e) {
			return false;
		}		
	}

	@Override
	public User save(User user) {
		Timestamp timestamp = new Timestamp(System.currentTimeMillis());		
		user.setTstampReg(timestamp);
		entityManager.merge(user);		
		return user;
	}

	@Override
	public User update(User user) {
		entityManager.merge(user);		
		return user;
	}

	@Override
	public void delete(Long id) {
		User user = entityManager.find(User.class, id);
		entityManager.remove(user);
		
	}

}
