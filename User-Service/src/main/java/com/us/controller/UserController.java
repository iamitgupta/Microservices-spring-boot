package com.us.controller;

import java.util.List;

import org.apache.hc.core5.http.HttpStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.us.model.User;
import com.us.services.UserService;

import jakarta.websocket.server.PathParam;

@RestController
@RequestMapping("user")
public class UserController {

	@Autowired
	private UserService service;

	@PostMapping("/save")
	private ResponseEntity<Object> saveUser(@RequestBody User user) {
		return ResponseEntity.status(HttpStatus.SC_CREATED).body(service.saveUser(user));
	}

	@GetMapping("/get/{userId}")
	private ResponseEntity<User> getUserById(@PathVariable("userId") Long userId) {
		return ResponseEntity.status(HttpStatus.SC_OK).body(service.getUserById(userId).get());

	}
	
	@GetMapping("/getall")
	private ResponseEntity<List<User>> getAllUsers() {
		return ResponseEntity.status(HttpStatus.SC_OK).body(service.getAllUsers());

	}
	
	@PutMapping("/update")
	private ResponseEntity<Object> updateUser(@RequestBody User user) {
		return ResponseEntity.status(HttpStatus.SC_OK).body(service.saveUser(user));
	}
	
	@DeleteMapping("/delete/{userId}")
	private ResponseEntity<String> deleteUserById(@PathParam("userId") final Long userId) {
		return ResponseEntity.status(HttpStatus.SC_OK).body(service.deleteUserById(userId));

	}

}
