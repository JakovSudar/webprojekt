package com.tasks.comment;

import com.tasks.payload.dto.CommentRequest;
import com.tasks.security.UserPrincipal;


public interface CommentService {	
	Comment getById(Long id);	
	Comment save(CommentRequest comment, UserPrincipal userPrincipal);
	Comment update(CommentRequest comment, UserPrincipal userPrincipal);
	void delete(CommentRequest comment, UserPrincipal userPrincipal);	
}
