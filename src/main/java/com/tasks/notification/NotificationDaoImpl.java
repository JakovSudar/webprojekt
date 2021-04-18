package com.tasks.notification;

import javax.persistence.EntityManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class NotificationDaoImpl implements NotificationDao {

	@Autowired
	private EntityManager em;
	
	@Override
	public Notification getById(Long id) {
		return em.find(Notification.class, id);
	}

	@Override
	public Notification save(Notification notification) {
		return em.merge(notification);
	}

	@Override
	public Notification update(Notification notification) {
		return em.merge(notification);
	}

	@Override
	public void delete(Notification notification) {
		em.remove(notification);

	}

}
