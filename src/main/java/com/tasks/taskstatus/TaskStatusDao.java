package com.tasks.taskstatus;

import java.util.List;

public interface TaskStatusDao {
	
	public List<TaskStatus> getAll();
	public TaskStatus findById(Long id);
}
