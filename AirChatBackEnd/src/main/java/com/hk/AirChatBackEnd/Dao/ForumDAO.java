package com.hk.AirChatBackEnd.Dao;

import java.util.List;

import com.hk.AirChatBackEnd.Models.BlogComment;
import com.hk.AirChatBackEnd.Models.Forum;
import com.hk.AirChatBackEnd.Models.ForumComment;

public interface ForumDAO {

public boolean addForum(Forum forum);
public boolean updateForum(Forum forum);
public boolean deleteForum(Forum forum);
public Forum getForum(int forumId);
public List<Forum> getAllForums();
public boolean approveForum(Forum forum);
public boolean rejectForum(Forum forum);
public List<Forum> forumRequest();
public boolean addForumComment(ForumComment forumcomment);
public List<ForumComment> getAllForumComments(int forumId);
}