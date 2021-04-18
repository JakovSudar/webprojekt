package com.tasks.comment;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tasks.payload.dto.CommentRequest;
import com.tasks.security.CurrentUser;
import com.tasks.security.UserPrincipal;
import com.tasks.util.ControllerExceptionHandler;

@RestController
@RequestMapping("/comment")
public class CommentController extends ControllerExceptionHandler {
	
	@Autowired
	private CommentService commentService;
	
	@PostMapping()		
	private Comment save(@Validated @RequestBody CommentRequest commentRequest, @CurrentUser UserPrincipal userPrincipal) throws Exception {
		
		return commentService.save(commentRequest, userPrincipal);
		
	}
	
	
	
	
	
	
}
