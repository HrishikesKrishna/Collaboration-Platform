package com.hk.AirChatBackEnd.Dao;

import java.util.List;

import com.hk.AirChatBackEnd.Models.Friend;

public interface FriendDAO {
public boolean addFriend(Friend friend);
public boolean removeFriend(Friend friend);
public boolean acceptReq(int friendId);
public boolean rejectReq(int friendId);
public Friend getFriendReq(int friendId,int userId);
public List<Friend> getAllReq(int userid);
public List<Friend> getAllFriends();
public List<Friend> getMyFriends(int userid);

}
