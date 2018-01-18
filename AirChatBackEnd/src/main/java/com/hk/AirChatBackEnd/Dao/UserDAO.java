package com.hk.AirChatBackEnd.Dao;

import java.util.List;

import com.hk.AirChatBackEnd.Models.User;

public interface UserDAO {
public boolean addUser(User user);
public boolean updateUser(User user);
public boolean deleteUser(User user);
public boolean updateStatus(User user);
public User getUser(int userId);
public User getUserbyemailId(String email);
public List<User> getAllUsers();
public boolean login(User user);
public boolean logincheck(User user);
public boolean emailCheck(User user);
public List<User> userrequest();
public boolean approveUser(User user);
public boolean rejectUser(User user);
public boolean saveorupdateUser(User user);
}
