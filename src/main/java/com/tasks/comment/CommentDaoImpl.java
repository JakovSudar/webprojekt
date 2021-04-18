package com.tasks.comment;

import javax.persistence.EntityManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class CommentDaoImpl implements CommentDao {
	
	@Autowired
	private EntityManager em;

	@Override
	public Comment getById(Long id) {
		return em.find(Comment.class, id);
	}

	@Override
	public Comment save(Comment comment) {
		return em.merge(comment);
	}

	@Override
	public Comment update(Comment comment) {
		return em.merge(comment);
	}

	@Override
	public void delete(Comment comment) {
		em.remove(comment);

	}

}
