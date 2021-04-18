package com.tasks.user;

import java.util.Optional;

public interface UserDAO {
	
	Optional<User> findByEmail(String email);
	Optional<User> findById(Long email);
	
	Boolean existsByEmail(String email);
	User save(User user);
	User update(User user);
	void delete(Long id);


}
