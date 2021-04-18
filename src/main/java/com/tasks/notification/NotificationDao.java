package com.tasks.notification;


public interface NotificationDao {
	
	Notification getById(Long id);	
	Notification save(Notification comment);
	Notification update(Notification comment);
	void delete(Notification comment);	

}
