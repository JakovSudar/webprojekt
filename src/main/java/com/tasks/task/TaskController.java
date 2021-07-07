package com.tasks.task;

import java.util.List;

import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tasks.mappers.TaskToTaskDtoMapper;
import com.tasks.payload.dto.CommentDto;
import com.tasks.payload.dto.NewTaskRequest;
import com.tasks.payload.dto.TaskDto;
import com.tasks.security.CurrentUser;
import com.tasks.security.UserPrincipal;
import com.tasks.util.ControllerExceptionHandler;

@RestController
@RequestMapping("/task")
public class TaskController extends ControllerExceptionHandler {
	
	@Autowired
	private TaskService taskService;
	
	
	@GetMapping("/{taskId}")
	public Task getById(@PathVariable Long taskId) {
		return taskService.getById(taskId);
	}
	
	@PostMapping()
	@Transactional
	public TaskDto save(@Valid @RequestBody NewTaskRequest taskReq, @CurrentUser UserPrincipal userPrincipal) {
		return taskService.save(taskReq, userPrincipal);
	}
	
	@GetMapping("/comments/{taskId}")
	public List<CommentDto> getCommentsForTask(@PathVariable int taskId){
		return taskService.getTasksComments((long) taskId);
	}
	
	@PostMapping("/orderList")
	public boolean editOrder(@RequestBody List<TaskDto> tasks) {
		return taskService.orderList(tasks);
		
	}
	
	@PostMapping("/update")
	@Transactional
	public TaskDto update(@RequestBody Task task) {
		return new TaskToTaskDtoMapper().map(taskService.update(task)); 
	}
	

}
