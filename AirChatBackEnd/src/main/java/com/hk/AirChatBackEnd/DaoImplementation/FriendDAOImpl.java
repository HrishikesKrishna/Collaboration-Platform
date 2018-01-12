package com.hk.AirChatBackEnd.DaoImplementation;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import com.hk.AirChatBackEnd.Dao.FriendDAO;
import com.hk.AirChatBackEnd.Models.Friend;

public class FriendDAOImpl implements FriendDAO{

		@Autowired
		SessionFactory sF;
		@Autowired
		public FriendDAOImpl(SessionFactory sF) {
			this.sF = sF;
		}
	
	@Transactional	
	@Override
	public boolean addFriend(Friend friend) {
		// TODO Auto-generated method stub
		
		return false;
	}

	

	@Override
	public boolean removeFriend(Friend friend) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean acceptReq(int friendId) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean rejectReq(int friendId) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Friend getFriendReq(int friendId, int userId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Friend> getAllReq(int userid) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Friend> getAllFriends() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Friend> getMyFriends(int userid) {
		// TODO Auto-generated method stub
		return null;
	}

}
