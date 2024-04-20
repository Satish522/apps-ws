package com.satish.apps.controller;


import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.satish.apps.exception.UserServiceException;
import com.satish.apps.model.UserModel;
import com.satish.apps.service.UserService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("users")
public class UserController {
	
	@Autowired
	UserService userService;
	
	Map<String, UserModel> users = new HashMap<>();
	

	@GetMapping
	public ResponseEntity getUsers(@RequestParam( name = "page1", defaultValue = "1") int page,
			@RequestParam(value = "limit", defaultValue = "50") int limit) {
		
		return new ResponseEntity(userService.getUser() , HttpStatus.OK);
	}
	
	@GetMapping(path = "/{userId}",produces = {MediaType.APPLICATION_XML_VALUE,MediaType.APPLICATION_JSON_VALUE})
	public ResponseEntity getUser(@PathVariable String userId) {
		
		if(true) {
			throw new UserServiceException("User service exception is thrown");
		}
		String firstName = null;
		
		int length = firstName.length();
		if(users.containsKey(userId)) {
			return new ResponseEntity(users.get(userId), HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}
		
	}
	
	@PostMapping()//produces = {MediaType.APPLICATION_XML_VALUE,MediaType.APPLICATION_JSON_VALUE} ,
				//consumes = {MediaType.APPLICATION_XML_VALUE,MediaType.APPLICATION_JSON_VALUE})
	public ResponseEntity createUser(@Valid @RequestBody UserModel user) {
		
		user = userService.createUser(user);
		return new ResponseEntity(user, HttpStatus.OK);
	}
	
	@PutMapping(produces = {MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE} ,
				consumes = {MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE} , 
				path = "/{userId}")
	public ResponseEntity updateUser(@PathVariable String userId, @Valid @RequestBody UserModel user) {
		
		users.put(userId, user);
		
		return new ResponseEntity(user, HttpStatus.OK);
	}
	
	
	
	@DeleteMapping(produces = {MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE},
				   path = "/{userId}" )
	public ResponseEntity deleteUser(@PathVariable String userId) {
		UserModel user = users.remove(userId);
		return new ResponseEntity(user, HttpStatus.OK);
	}
}
