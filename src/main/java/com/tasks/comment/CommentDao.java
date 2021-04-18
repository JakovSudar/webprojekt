package com.tasks.comment;



public interface CommentDao {
	Comment getById(Long id);	
	Comment save(Comment comment);
	Comment update(Comment comment);
	void delete(Comment comment);	

}
