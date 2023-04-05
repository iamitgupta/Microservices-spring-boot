package com.us.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.us.model.User;
import com.us.repository.UserRepository;

@Service
public class UserService {
	
	@Autowired
	private UserRepository repository;

	public User saveUser(User user) {
		return repository.save(user);
	}

	public Optional<User> getUserById(Long userId) {
		return repository.findById(userId);
	}

	public List<User> getAllUsers() {
		return repository.findAll();
	}

	public String deleteUserById(Long userId) {
		repository.deleteById(userId);
		if(repository.findById(userId).isEmpty()) {
			return "User with id : "+userId+" deleted";
		}
		return "Failed to delete Product with id : "+userId;
	}

}
