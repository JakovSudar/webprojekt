package com.tasks.task;

import java.util.List;

import javax.persistence.EntityManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class TaskDaoImpl implements TaskDao {

	@Autowired
	private EntityManager em;
	@Override
	public Task getById(Long id) {
		try {
			return em.find(Task.class, id);
		} catch (Exception e) {
			return null;
		}
	}

	@Override
	public Task save(Task task) {
		return em.merge(task);
	}

	@Override
	public Task update(Task task) {
		return em.merge(task);
	}

	@Override
	public void delete(Task task) {
		em.remove(task);
	}
}
