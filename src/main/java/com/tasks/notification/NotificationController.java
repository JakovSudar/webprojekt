package com.tasks.notification;

import java.util.List;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tasks.security.CurrentUser;
import com.tasks.security.UserPrincipal;
import com.tasks.user.User;
import com.tasks.user.UserRepository;

@RestController
@RequestMapping("/notification")
public class NotificationController {
	
	@Autowired
	private NotificationService notificationService;
	@Autowired
	private UserRepository userRepository;
	
	@GetMapping()
	private List<Notification> getNotifications(@CurrentUser UserPrincipal userPrincipal) {
		return userRepository.findById(userPrincipal.getId()).get().getNotifications();		
	}
	
	
	@PostMapping("/{id}")	
	private Notification changeReaded(@CurrentUser UserPrincipal userPrincipal, @PathVariable int id) throws Exception {
		
		User user = userRepository.findById(userPrincipal.getId()).get();
		Notification notif = notificationService.getById((long) id);
		if(notif.getUser().getUserId() != user.getUserId()) {
			throw new Exception("Korisnik nije vlasnik notifikacije.");
		}
		notif.setStatus((long) (notif.getStatus()==0?1:0));
		notificationService.save(notif);
		return notif;
	}
	
	@PostMapping("readAll")
	private boolean readAll(@CurrentUser UserPrincipal userPrincipal) throws Exception{
		return notificationService.readAll(userPrincipal.getId());
	}
	
	
	@DeleteMapping("/{id}")	
	private void delete(@CurrentUser UserPrincipal userPrincipal, @PathVariable int id) throws Exception {
		User user = userRepository.findById(userPrincipal.getId()).get();
		Notification notif = notificationService.getById((long) id);
		if(notif.getUser().getUserId() != user.getUserId()) {
			throw new Exception("Korisnik nije vlasnik notifikacije.");			
		}
		notificationService.delete(notif);
	}
}
