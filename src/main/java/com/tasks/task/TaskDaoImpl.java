package com.tasks.task;

import java.util.List;

import javax.persistence.EntityManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.tasks.payload.dto.TaskDto;

import ch.qos.logback.core.status.Status;

@Repository
public class TaskDaoImpl implements TaskDao {
	
	@Autowired
	private JdbcTemplate jdbcTemplate;

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
		Task dbTask = em.find(Task.class,task.getTaskId());		
		dbTask.setDescription(task.getDescription());
		dbTask.setTitle(task.getTitle());
		dbTask.setStatus(task.getStatus());
		return em.merge(dbTask);
	}

	@Override
	public void delete(Task task) {
		em.remove(task);
	}

	@Override
	public boolean orderList(List<TaskDto> taskovi) {
		String query = "UPDATE TASK SET PRIORITY=? WHERE TASK_ID=?";
		
		for (TaskDto taskDto : taskovi) {
			try {
				jdbcTemplate.update(query,new Object[] {taskDto.getPriority(),taskDto.getTaskId()});
			} catch (Exception e) {
				return false;
			}
		}		
		return true;
	}
}
