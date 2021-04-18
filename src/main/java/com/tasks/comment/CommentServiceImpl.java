package com.tasks.comment;

import java.sql.Timestamp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.tasks.payload.dto.CommentRequest;
import com.tasks.security.UserPrincipal;
import com.tasks.task.Task;
import com.tasks.task.TaskDao;
import com.tasks.user.User;
import com.tasks.user.UserRepository;

@Service
public class CommentServiceImpl implements CommentService {
	
	@Autowired
	private CommentDao commentDao;
	
	@Autowired
	private UserRepository userDao;
	
	@Autowired
	private TaskDao taskDao;

	@Override
	public Comment getById(Long id) {
		return commentDao.getById(id);
	}

	@Override
	@Transactional
	public Comment save(CommentRequest comment, UserPrincipal userPrincipal) {
		User user = userDao.findById(userPrincipal.getId()).get();
		Task task = taskDao.getById(comment.getTaskId()); 
		Comment temp = new Comment();
		temp.setCommText(comment.getComment());
		temp.setTask(task);
		temp.setUser(user);
		temp.setCreatedAt(new Timestamp(System.currentTimeMillis()));	
		
		return commentDao.save(temp);
	}

	@Override
	public Comment update(CommentRequest comment, UserPrincipal userPrincipal) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void delete(CommentRequest comment, UserPrincipal userPrincipal) {
		// TODO Auto-generated method stub

	}

}
