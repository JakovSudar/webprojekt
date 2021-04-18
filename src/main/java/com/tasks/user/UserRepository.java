package com.tasks.user;

import java.util.Optional;

import org.springframework.stereotype.Repository;



public interface UserRepository {
	
	Optional<User> findByEmail(String email);
	Optional<User> findById(Long email);
	
	Boolean existsByEmail(String email);
	User save(User user);
	User update(User existingUser);
	void delete(Long id);

}
