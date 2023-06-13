package com.akhm.service;

import java.util.List;

import com.akhm.repository.model.UserModel;

public interface UserService {
	public UserModel insertUser(UserModel userModel);
	public List<UserModel> getAllUsers();
	public UserModel getUser(String emailId,String password);
	public void updateUser(UserModel userModel);
	public void deleteUser(Integer userId);
	public UserModel getUser(Integer userId); 

}
