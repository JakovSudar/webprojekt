package com.tasks.task;

import java.util.List;

import com.tasks.payload.dto.TaskDto;

public interface TaskDao {
	
	Task getById(Long id);	
	Task save(Task task);
	Task update(Task task);
	void delete(Task task);	
	
	boolean orderList(List<TaskDto> taskovi);
	
}
