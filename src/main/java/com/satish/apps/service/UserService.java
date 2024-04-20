package com.satish.apps.service;

import java.util.Collection;
import java.util.List;

import com.satish.apps.model.UserModel;

public interface UserService {

	public UserModel createUser(UserModel user);
	
	public Collection<UserModel> getUser();
}
