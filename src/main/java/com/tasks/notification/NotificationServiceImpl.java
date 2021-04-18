package com.tasks.notification;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class NotificationServiceImpl implements NotificationService {

	@Autowired
	private NotificationDao notificationDAO;
	
	@Override
	public Notification getById(Long id) {
		return notificationDAO.getById(id);
	}

	@Override
	@Transactional
	public Notification save(Notification notification) {		
		return notificationDAO.save(notification);
	}

	@Override
	public Notification update(Notification notification) {		
		return notificationDAO.update(notification);
	}

	@Override
	@Transactional
	public void delete(Notification notification) {
		notificationDAO.delete(notification);

	}

}
