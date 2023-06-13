package com.akhm.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.akhm.exception.PetrolProjectException;
import com.akhm.repository.UserRepository;
import com.akhm.repository.model.UserModel;
import com.akhm.service.UserService;
@Service
public class UserServiceImpl  implements UserService{

	private UserRepository userRepo;
	@Override
	public UserModel insertUser(UserModel userModel) {
		UserModel userModel2=null;
		userModel2=userRepo.save(userModel);
		return userModel2;
	}

	@Override
	public List<UserModel> getAllUsers() {
		List<UserModel> userModels=null;
		try {
			
			userModels=userRepo.findAll();
		} catch (Exception e) {
			
			throw new PetrolProjectException(e.getMessage());
		}
		return userModels;
	}

	@Override
	public UserModel getUser(String emailId, String password) {
		UserModel userModel=null;
		try {
			userModel=userRepo.findByEmailIdAndPassword(emailId,password);
		} catch (Exception e) {
			throw new PetrolProjectException(e.getMessage());
		}
		return userModel;

	}

	@Override
	public void updateUser(UserModel userModel) {
		try {
			userRepo.save(userModel);
		} catch (Exception e) {
			throw new PetrolProjectException(e.getMessage());
		}

	}

	@Override
	public void deleteUser(Integer userId) {
		try {
			userRepo.deleteById(userId);
		} catch (Exception e) {
			throw new PetrolProjectException(e.getMessage());
		}

	}

	@Override
	public UserModel getUser(Integer userId) {
		UserModel userModel=null;
		try {
			userModel=userRepo.findByUserId(userId);
		} catch (Exception e) {
			throw new PetrolProjectException(e.getMessage());
		}
		return userModel;
	}

}
