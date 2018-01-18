package com.hk.AirChatMiddleWare.Controllers;

import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

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
				User tempuser2=new User();
				if(userdao.logincheck(user))
				{
					User tempuser=userdao.getUserbyemailId(user.getEmailId());
					if(tempuser.getStatus().equals("P"))
					{
						tempuser2.setErrorCode("200");
						tempuser2.setErrorMessage("Please wait for Admin approval");
						return new ResponseEntity<User>(tempuser2,HttpStatus.OK);
						
					}
					else
					{
						tempuser2.setErrorCode("200");
						tempuser2.setErrorMessage("Your account request has been rejected ");
						return new ResponseEntity<User>(tempuser2,HttpStatus.OK);
						
					}
				}
			else
			{
				if(userdao.emailCheck(user))
				{
					tempuser2.setErrorCode("200");
					tempuser2.setErrorMessage("Email ID or password incorrect");
					return new ResponseEntity<User>(tempuser2,HttpStatus.OK);
				}
				else
				{
					tempuser2.setErrorCode("200");
					tempuser2.setErrorMessage("Not yet registered");
					return new ResponseEntity<User>(tempuser2,HttpStatus.OK);
				}
			}		
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
	@GetMapping(value="/getUserReq")
	public List<User> getUserReq(){
	 System.out.println("Fetching User Req");
		List<User> userreq=(List<User>)userdao.userrequest();
		System.out.println("User Req");

	return userreq;		
} 
	@GetMapping(value="/approveUser/{email}")
	public ResponseEntity<String> approveUser(@PathVariable("email") String emailId)
	 {
		 String email=emailId+".com";
		 User user =userdao.getUserbyemailId(email);
		 user.setStatus("A");
		 boolean isSaved=userdao.updateUser(user);
		 if(isSaved)
		 {
			 return new ResponseEntity<String>("User approved",HttpStatus.OK);
			}
			else
			{
				return new ResponseEntity<String>("User not approved",HttpStatus.BAD_REQUEST);
			}
}
		
		 
		 
	 
	 
	 @RequestMapping(value="/rejectUser/{email}")
	 public ResponseEntity<String> rejectUser(@PathVariable("email") String emailId)
	 {
		 String email=emailId+".com";
		 User user =userdao.getUserbyemailId(email);
		 user.setStatus("R");
		 boolean isSaved=userdao.updateUser(user);
		 if(isSaved)
		 {
			 return new ResponseEntity<String>("User rejected",HttpStatus.OK);
			}
			else
			{
				return new ResponseEntity<String>("User not rejected",HttpStatus.BAD_REQUEST);
			}

		 
}
	 @PostMapping(value="/upload")
	 public ModelAndView  upload(HttpServletRequest request,@RequestParam("uploadedFile") MultipartFile file,HttpSession session )
	 {
	 	  /* String filepath = request.getSession().getServletContext().getRealPath("/") + "resources/product/" + file.getOriginalFilename();
	 		*/
		 
		 User user = (User)session.getAttribute("currentUser");
		 	System.out.println(user.getEmailId());
		 		user.setImage(user.getEmailId()+".jpg");
		 	userdao.saveorupdateUser(user);
		 	
		 	
	 	    String filepath ="C:/Users/USER/workspace/Collaboration Platform/AirChatFrontEnd/WebContent/IMAGES/" + user.getEmailId()+".jpg";
	 		
	 		
	 		System.out.println(filepath);
	 		try {
	 			byte imagebyte[] = file.getBytes();
	 			BufferedOutputStream fos = new BufferedOutputStream(new FileOutputStream(filepath));
	 			fos.write(imagebyte);
	 			fos.close();
	 			} catch (IOException e) {
	 			e.printStackTrace();
	 			} catch (Exception e) {
	 			// TODO Auto-generated catch block
	 			e.printStackTrace();
	 			}
	 		
	 	
	 	ModelAndView mv = new ModelAndView("return");
		return mv;
	 }

	
}
