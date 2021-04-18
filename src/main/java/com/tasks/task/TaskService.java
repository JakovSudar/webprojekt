package com.tasks.task;

import java.util.List;

import com.tasks.payload.dto.CommentDto;
import com.tasks.payload.dto.NewTaskRequest;
import com.tasks.payload.dto.TaskDto;
import com.tasks.security.UserPrincipal;
import com.tasks.user.User;

public interface TaskService {
	
	Task getById(Long id);
	TaskDto save(NewTaskRequest taskReq, UserPrincipal userPrincipal);
	Task update(Task task);
	void delete(Task task);
	void addWorkerToTask(Task task, List<User> workers, User loggedUser) throws Exception;
	List<Task> getTasksForUserByProject(Long projectId, Long userId);
	List<CommentDto> getTasksComments(Long taskId);
	
	
	
}
