package com.akhm.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.akhm.repository.model.UserModel;
@Repository
public interface UserRepository extends JpaRepository<UserModel, Integer>{

	public UserModel findByUserId(Integer userId);

	public UserModel findByEmailIdAndPassword(String emailId, String password);

}
