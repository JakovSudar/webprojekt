package com.tasks.notification;

public interface NotificationService {
	
	Notification getById(Long id);	
	Notification save(Notification notification);
	Notification update(Notification notification);
	void delete(Notification notification);	

}
