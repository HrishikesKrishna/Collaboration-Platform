package com.hk.AirChatMiddleWare.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hk.AirChatBackEnd.Dao.UserDAO;
import com.hk.AirChatBackEnd.Models.User;

@RestController
@RequestMapping("/user")
public class UserController {
	@Autowired
	UserDAO userdao;
	
	@PostMapping(value="/insertUser")
	public ResponseEntity<User> insertUser(@RequestBody User user)
	{
		if(userdao.addUser(user))
		{
			return new ResponseEntity<User>(user,HttpStatus.OK);
		}
		else
		{
		return new ResponseEntity<User>(user,HttpStatus.BAD_REQUEST);	
		}
	}
}
