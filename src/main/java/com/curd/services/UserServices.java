package com.curd.services;

import java.util.List;

import com.curd.entity.UserDetails;

public interface UserServices {
	
	UserDetails saveUser(UserDetails details);
	UserDetails updateUser(UserDetails userDetails , Integer userId);
	UserDetails getUserById(Integer userId);
	List<UserDetails> getAllUsers();
	Boolean deleteUser(Integer userId);

}
