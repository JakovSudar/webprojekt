package com.tasks.user;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class UserRepositoryImpl implements UserRepository {

	@Autowired
	private UserDAO userDao;
	
	@Override
	public Optional<User> findByEmail(String email) {
		return userDao.findByEmail(email);
	}

	@Override
	public Optional<User> findById(Long id) {
		return userDao.findById(id);
	}

	@Override
	public Boolean existsByEmail(String email) {
		return userDao.existsByEmail(email);
	}

	@Override
	public User save(User user) {
		return userDao.save(user);
	}

	@Override
	public User update(User existingUser) {
		return userDao.update(existingUser);
	}

	@Override
	public void delete(Long id) {
		 userDao.delete(id);
		
	}

}
