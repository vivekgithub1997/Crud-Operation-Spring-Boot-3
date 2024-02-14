package com.curd.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.curd.entity.UserDetails;
import com.curd.repo.UserRepo;

@Service
public class UserServicesimpl implements UserServices {

	@Autowired
	private UserRepo repo;

	@Override
	public UserDetails saveUser(UserDetails details) {
		UserDetails save = repo.save(details);
		if (save!=null) {
			return save;
			
		}

		return null;
	}

	@Override
	public UserDetails updateUser(UserDetails userDetails, Integer userId) {
		UserDetails newUserSave = null;
		Optional<UserDetails> userbyId = repo.findById(userId);
		if (userbyId.isPresent()) {
			UserDetails userPresent = userbyId.get();
			userPresent.setUserName(userDetails.getUserName());
			userPresent.setUserEmail(userDetails.getUserEmail());
			userPresent.setUserAge(userDetails.getUserAge());
			newUserSave = repo.save(userPresent);

		}
		return newUserSave;
	}

	@Override
	public UserDetails getUserById(Integer userId) {

		Optional<UserDetails> getUser = repo.findById(userId);
		if (getUser.isPresent()) {
			UserDetails userPresent = getUser.get();
			return userPresent;
		}

		return null;
	}

	@Override
	public List<UserDetails> getAllUsers() {
		List<UserDetails> getAllUsers = repo.findAll();

		return getAllUsers;

	}

	@Override
	public Boolean deleteUser(Integer userId) {

		boolean status = false;
		repo.deleteById(userId);

		status = true;
		return status;
	}

}
