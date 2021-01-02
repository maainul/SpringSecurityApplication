package com.SpringSecurityApp.service;

import com.SpringSecurityApp.core.exception.UserAlreadyExistException;
import com.SpringSecurityApp.data.user.UserData;


public interface UserService {

	void register(final UserData user) throws UserAlreadyExistException;
	
	boolean checkIfUserExist(final String email);
	
	
}
