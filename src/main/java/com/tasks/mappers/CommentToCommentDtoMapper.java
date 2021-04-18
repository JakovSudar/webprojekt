package com.tasks.mappers;



import java.util.ArrayList;
import java.util.List;

import com.tasks.comment.Comment;
import com.tasks.payload.dto.CommentDto;


public class CommentToCommentDtoMapper {
	
	public CommentDto map(Comment comment) {			
		CommentDto temp = new CommentDto();
		temp.setCommentId(comment.getCommentId());
		temp.setCommText(comment.getCommText());
		temp.setCreatedAt(comment.getCreatedAt());
		temp.setUser(new UserToUserDtoMapper().map(comment.getUser()));
		return temp;
	}	
	
	public List<CommentDto> mapList(List<Comment> comments){
		List<CommentDto> mapped = new ArrayList<CommentDto>();
		if(comments !=null) {
			for (Comment comment : comments) {
				mapped.add(map(comment));
			}
		}
		return mapped;
	}
	

}


