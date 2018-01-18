package com.hk.AirChatMiddleWare.Controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hk.AirChatBackEnd.Dao.ForumDAO;
import com.hk.AirChatBackEnd.Dao.UserDAO;
import com.hk.AirChatBackEnd.Models.Blog;
import com.hk.AirChatBackEnd.Models.BlogComment;
import com.hk.AirChatBackEnd.Models.Forum;
import com.hk.AirChatBackEnd.Models.ForumComment;
import com.hk.AirChatBackEnd.Models.User;
import com.hk.AirChatBackEnd.Util.Date_Time;

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
	
	@GetMapping(value="/getAllForums")
	public ResponseEntity<List<Forum>> getAllForums(){
		List<Forum> foruml=(List<Forum>)forumDAO.getAllForums();
		return new ResponseEntity<List<Forum>>(foruml,HttpStatus.OK);
	}
	
	@GetMapping(value="/getForumReq")
	public List<Forum> getForumReq(){
	 System.out.println("Fetching Forum Req");
		List<Forum> forumreq=(List<Forum>)forumDAO.forumRequest();
		System.out.println("Forum Req");
		return forumreq;		
} 
	@GetMapping(value="/approveForum/{fid}")
	public ResponseEntity<String> approveUser(@PathVariable("fid") int forid)
	 {
		 Forum tempforum =forumDAO.getForum(forid);
		 tempforum.setStatus("A");
		 boolean isSaved=forumDAO.updateForum(tempforum);
		 if(isSaved)
		 {
			 return new ResponseEntity<String>("Forum approved",HttpStatus.OK);
			}
			else
			{
				return new ResponseEntity<String>("Forum not approved",HttpStatus.BAD_REQUEST);
			}
}
		
	@GetMapping(value="/getForum/{fid}")
	public ResponseEntity<Forum> getForum(@PathVariable("fid")int forumid)
	{
		Forum tempforum=forumDAO.getForum(forumid);
		if(tempforum==null)
		{
			return new ResponseEntity<Forum>(tempforum,HttpStatus.BAD_REQUEST);
		}
		else
		{
			return new ResponseEntity<Forum>(tempforum,HttpStatus.OK);
		}
	}
	@GetMapping(value="/insertForumComment/{forumId}/{emailId}/{forumcomment}")
	public ResponseEntity<String> addForumComment(@PathVariable("forumId")int forumId,@PathVariable("emailId")String emailId,@PathVariable("forumcomment")String forumcomment)
	{
		System.out.println(forumId+emailId+forumcomment);
		ForumComment fc=new ForumComment();
		fc.setForumId(forumId);
		fc.setUsername(emailId);
		fc.setForumcomment(forumcomment);
		Date_Time dt=new Date_Time();
		String date=dt.getDateTime();
		fc.setCommentDate(date);
		boolean isSaved=forumDAO.addForumComment(fc);
		if(isSaved){
			return new ResponseEntity<String>("Forumcomment added succesfully",HttpStatus.OK);
		}
		else
		{
			return new ResponseEntity<String>("Problem in adding forum comment",HttpStatus.BAD_REQUEST);
		}
	
	}
	 
	 
	 @RequestMapping(value="/rejectUser/{fid}")
	 public ResponseEntity<String> rejectUser(@PathVariable("fid") int forid)
	 {
		 Forum tempforum =forumDAO.getForum(forid);
		 tempforum.setStatus("R");
		 boolean isSaved=forumDAO.updateForum(tempforum);
		 if(isSaved)
		 {
			 return new ResponseEntity<String>("Forum rejected",HttpStatus.OK);
			}
			else
			{
				return new ResponseEntity<String>("Forum not rejected",HttpStatus.BAD_REQUEST);
			}
		
		
	}
	 	@GetMapping(value="/getForumComments/{forumid}")
		public ResponseEntity<List<ForumComment>> getForumComments(@PathVariable("forumid")int forumid){
			List<ForumComment> forumc=(List<ForumComment>)forumDAO.getAllForumComments(forumid);
			if(forumc.isEmpty()){
				return null;
			}
			else
			{
			return new ResponseEntity<List<ForumComment>>(forumc,HttpStatus.OK);
			}
		}

}

	
