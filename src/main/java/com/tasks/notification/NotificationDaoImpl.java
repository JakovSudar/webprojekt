package com.tasks.notification;

import javax.persistence.EntityManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class NotificationDaoImpl implements NotificationDao {

	@Autowired
	private EntityManager em;
	
	 @Autowired
	 private JdbcTemplate jdbcTemplate;
	
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

	@Override
	public boolean readAll(Long userId) {
		String query="UPDATE notification SET status = 1 where user_id = ?";
		
		try {
			jdbcTemplate.update(query,new Object[] {userId});
		} catch (Exception e) {
			return false;
		}
		
		return true;
	}

}
