package com.tasks.taskstatus;

import java.util.List;

import javax.persistence.EntityManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class TaskStatusDaoImpl implements TaskStatusDao {

	@Autowired
	private EntityManager em;
	@Override
	public List<TaskStatus> getAll() {
		return (List<TaskStatus>) em.createQuery("select from TaskStatus");
	}
	@Override
	public TaskStatus findById(Long id) {
		return em.find(TaskStatus.class, id);
	}

}
