package com.tasks.mappers;

import java.util.ArrayList;
import java.util.List;
import com.tasks.payload.dto.TaskDto;
import com.tasks.task.Task;


public class TaskToTaskDtoMapper {
	public TaskDto map(Task task) {
		TaskDto mapped = new TaskDto();
		mapped.setTitle(task.getTitle());
		mapped.setAssignedUsers(new UserToUserDtoMapper().mapList(task.getAssignedUsers()));
		mapped.setCreatedAt(task.getCreatedAt());
		mapped.setDescription(task.getDescription());
		mapped.setEndDate(task.getEndDate());
		mapped.setOwner(new UserToUserDtoMapper().map(task.getOwner()));
		mapped.setPriority(task.getPriority());
		mapped.setStatus(task.getStatus());
		mapped.setTaskId(task.getTaskId());
		return mapped;
	}
	
	public List<TaskDto> mapList(List<Task> tasks){
		List<TaskDto> mapped = new ArrayList<TaskDto>();
		if(tasks!=null) {
			for (Task task : tasks) {
				mapped.add(map(task));
			}			
		}
		return mapped;
	}
}
