package com.hk.AirChatBackEnd.Dao;

import java.util.List;

import com.hk.AirChatBackEnd.Models.User;

public interface UserDAO {
public boolean addUser(User user);
public boolean updateUser(User user);
public boolean deleteUser(User user);
public boolean updateStatus(User user);
public User getUser(int userId);
public List<User> getAllUsers();

}
