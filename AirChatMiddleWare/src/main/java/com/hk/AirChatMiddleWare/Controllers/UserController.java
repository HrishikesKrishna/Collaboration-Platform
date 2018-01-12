package com.hk.AirChatMiddleWare.Controllers;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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
		System.out.println(user);
		if(userdao.addUser(user))
		{
			return new ResponseEntity<User>(user,HttpStatus.OK);
		}
		else
		{
		return new ResponseEntity<User>(user,HttpStatus.BAD_REQUEST);	
		}
	}
	
	@PostMapping(value="/login")
	public ResponseEntity<User> login(@RequestBody User user,HttpSession http)
	{
			if(userdao.login(user))
			{
				User tempuser=userdao.getUserbyemailId(user.getEmailId());
				tempuser.setIsOnline("ONLINE");
				userdao.updateStatus(tempuser);
				tempuser.setErrorCode("200");
				tempuser.setErrorMessage("Login Success");
				http.setAttribute("currentUser", tempuser);
				return new ResponseEntity<User>(tempuser,HttpStatus.OK);
			}
			else
			{
				return new ResponseEntity<User>(user,HttpStatus.BAD_GATEWAY);
			}		
	}
	@GetMapping(value="/logout/{emailId}")
	public ResponseEntity<String> logout(@PathVariable("emailId") String emailId){
		String email=emailId+".com";//messes with the com of package name
		User tempuser=userdao.getUserbyemailId(email);
		tempuser.setIsOnline("OFFLINE");
		userdao.updateStatus(tempuser);
		tempuser.setErrorCode("200");
		tempuser.setErrorMessage("Logout Succesfull");
		return new ResponseEntity<String>("Logout Success",HttpStatus.OK);
	}
	
}
