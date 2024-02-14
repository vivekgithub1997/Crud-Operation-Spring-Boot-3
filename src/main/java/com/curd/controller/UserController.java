package com.curd.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.curd.entity.UserDetails;
import com.curd.services.UserServices;

@RestController
public class UserController {

	@Autowired
	private UserServices services;

	@PostMapping("/saveuser")
	public UserDetails createUser(@RequestBody UserDetails userDetails) {
		UserDetails saveUser = services.saveUser(userDetails);
		return saveUser;

	}

	@GetMapping("/users")
	public List<UserDetails> getAllUsers() {
		 List<UserDetails> allUsers = services.getAllUsers();
		
		return allUsers;

	}

	@PutMapping("user/{userId}")
	public UserDetails updateUser(@RequestBody UserDetails userDetails,@PathVariable Integer userId) {
		UserDetails updateUser = services.updateUser(userDetails, userId);
		return updateUser;
	}

	@GetMapping("/user/{userId}")
	public UserDetails getUser(@PathVariable Integer userId) {
		UserDetails userById = services.getUserById(userId);
		return userById;
	}

	@DeleteMapping("/user/{userId}")
	public String deleteUser(@PathVariable Integer userId) {
		Boolean deleteUser = services.deleteUser(userId);
		if (deleteUser) {

			return "Deleted";
		}
		return "NOt Deleted Somwthing Went Wrong..!!";
	}

}
