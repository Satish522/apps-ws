package com.satish.apps.service.impl;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.satish.apps.model.UserModel;
import com.satish.apps.service.UserService;
import com.satish.apps.util.Utils;

@Service
public class UserServiceImpl implements UserService {

	Map<String, UserModel> users = new HashMap<>();
	Utils utils;
	
	public UserServiceImpl() {}
	
	@Autowired
	public UserServiceImpl(Utils utils) {
		this.utils = utils;
	}
	
	@Override
	public UserModel createUser(UserModel user) {
		String userId = utils.generateUserId();
		user.setUserId(userId);
		users.put(userId, user);
		return user;
	}

	@Override
	public Collection<UserModel> getUser() {
		// TODO Auto-generated method stub
		return users.values();
	}

	
}
