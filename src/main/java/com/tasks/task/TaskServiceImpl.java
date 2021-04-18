package com.tasks.task;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tasks.exception.CustomException;
import com.tasks.mappers.CommentToCommentDtoMapper;
import com.tasks.mappers.TaskToTaskDtoMapper;
import com.tasks.notification.Notification;
import com.tasks.notification.NotificationDao;
import com.tasks.notification.NotificationService;
import com.tasks.payload.dto.CommentDto;
import com.tasks.payload.dto.NewTaskRequest;
import com.tasks.payload.dto.TaskDto;
import com.tasks.projekt.Projekt;
import com.tasks.projekt.ProjektDAO;
import com.tasks.security.UserPrincipal;
import com.tasks.taskstatus.TaskStatus;
import com.tasks.taskstatus.TaskStatusDao;
import com.tasks.user.User;
import com.tasks.user.UserDAO;

@Service
public class TaskServiceImpl implements TaskService {

	@Autowired
	private TaskDao taskDao;	
	@Autowired
	private UserDAO userDao;
	@Autowired
	private ProjektDAO projektDao;
	@Autowired
	private TaskStatusDao taskStatusDao;
	@Autowired
	private NotificationDao notificationDao;
	
	@Override
	public Task getById(Long id) {
		return taskDao.getById(id);
	}

	@Override
	public TaskDto save(NewTaskRequest taskReq, UserPrincipal userPrincipal) {
		User tempUsr = userDao.findById(userPrincipal.getId()).get();
		Projekt tempProjekt = projektDao.getById(taskReq.getProjektId());
		TaskStatus sts = taskStatusDao.findById(taskReq.getStatusId());		
		Task task = new Task();		
		if(taskReq.getAssignedUsersIDs() != null) {
			List<User> dbUsers = new ArrayList<User>();			
			for (Long  workerId : taskReq.getAssignedUsersIDs()) {			
				Optional<User> dbUser = userDao.findById(workerId);
				if(dbUser.isPresent()) {
					User user = dbUser.get();
					if(user.getAssignedProjects().stream().filter(projekt->tempProjekt.getProjektId()
							.equals(projekt.getProjektId())).findFirst().orElse(null) != null) {
						
						dbUsers.add(dbUser.get());						
						
						Notification notification = new Notification();
						notification.setUser(user);
						notification.setDescription("Dobili ste novi zadatak - "+taskReq.getTitle() );
						notification.setCreatedAt(new Timestamp(System.currentTimeMillis()));
						notification.setStatus((long) 0);
						notificationDao.save(notification);
					}					
				}
			}			
			task.setAssignedUsers(dbUsers);
		}		
		task.setTitle(taskReq.getTitle());
		task.setCreatedAt(new Timestamp(System.currentTimeMillis()));
		task.setOwner(tempUsr);
		task.setProjekt(tempProjekt);
		task.setStatus(sts);
		task.setDescription(taskReq.getDescription());
		task.setPriority(taskReq.getPriority());
		return new TaskToTaskDtoMapper().map(taskDao.save(task));
	}

	@Override
	public Task update(Task task) {
		return taskDao.update(task);
	}

	@Override
	public void delete(Task task) {
		taskDao.delete(task);

	}

	@Override
	public void addWorkerToTask(Task task, List<User> workers, User loggedUser) throws Exception {
		
		Task tempTask = taskDao.getById(task.getTaskId());
		if(tempTask==null) {
			throw new CustomException("Ne postoji zadatak");
		}
		if(tempTask.getOwner().getUserId()!= loggedUser.getUserId()) {
			throw new CustomException("Samo vlasnik zadatka može dodavati ljude.");
		}
		for (User user : workers) {
			Optional<User> dbUser = userDao.findById(user.getUserId());
			if(dbUser.isEmpty()) {
				continue;
			}
			if(user.getAssignedProjects().stream().filter(projekt-> tempTask.getProjekt().getProjektId()
							.equals(projekt.getProjektId())).findFirst().orElse(null) != null) {
				
				tempTask.addAssignedUser(user);
				Notification notification = new Notification();
				notification.setUser(user);
				notification.setDescription("Dobili ste novi zadatak - "+task.getTitle() );
				notification.setCreatedAt(new Timestamp(System.currentTimeMillis()));
				notification.setStatus((long) 0);
				notificationDao.save(notification);
			}
		}
		taskDao.update(tempTask);
		
	}

	@Override
	public List<Task> getTasksForUserByProject(Long projectId, Long userId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<CommentDto> getTasksComments(Long taskId) {
		Task task = taskDao.getById(taskId);
		return new CommentToCommentDtoMapper().mapList(task.getComments());
	}

}
