package com.hk.AirChatMiddleWare.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hk.AirChatBackEnd.Dao.ForumDAO;
import com.hk.AirChatBackEnd.Dao.UserDAO;
import com.hk.AirChatBackEnd.Models.Forum;

@RestController
@RequestMapping("/forum")
public class ForumController {
	@Autowired
	ForumDAO forumDAO;
	
	@Autowired
	UserDAO userDAO;
	
	@PostMapping(value="/insertForum")
	public ResponseEntity<Forum> addForum(@RequestBody Forum forum)
	{
		forum.setCreatedDate(new java.util.Date());
		System.out.println("Forum : "+forum);
		boolean isSaved=forumDAO.addForum(forum);
		if(isSaved){
			return new ResponseEntity<Forum>(forum,HttpStatus.OK);
		}
		else
		{
			return new ResponseEntity<Forum>(forum,HttpStatus.BAD_REQUEST);
		}
	}
}
