package com.tasks.task;

import java.util.List;

public interface TaskDao {
	
	Task getById(Long id);	
	Task save(Task task);
	Task update(Task task);
	void delete(Task task);	
	
}
