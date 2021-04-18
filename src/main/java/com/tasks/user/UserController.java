package com.tasks.user;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.tasks.exception.ResourceNotFoundException;
import com.tasks.security.CurrentUser;
import com.tasks.security.UserPrincipal;

@RestController
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @GetMapping("/user/me")    
    public User getCurrentUser(@CurrentUser UserPrincipal userPrincipal) {
        return userRepository.findByEmail(userPrincipal.getEmail())
                .orElseThrow(() -> new ResourceNotFoundException("User", "id", userPrincipal.getId()));
    } 
    
    @DeleteMapping("/user/{userId}")
    @Transactional
    public void delete(@PathVariable Long userId) {
    	userRepository.delete(userId);
    }
    
    
}
