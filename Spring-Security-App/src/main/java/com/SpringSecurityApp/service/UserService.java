package com.SpringSecurityApp.service;

import com.SpringSecurityApp.core.exception.InvalidTokenException;
import com.SpringSecurityApp.core.exception.UserAlreadyExistException;
import com.SpringSecurityApp.data.user.UserData;
import com.SpringSecurityApp.entity.UserEntity;


public interface UserService {

	void register(final UserData user) throws UserAlreadyExistException;
	void sendRegistrationConfirmationEmail(final UserEntity user);
	boolean checkIfUserExist(final String email);
	boolean verifyUser(final String token) throws InvalidTokenException;

	
	
}
