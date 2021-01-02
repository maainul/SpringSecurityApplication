package com.SpringSecurityApp.service.impl;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.SpringSecurityApp.core.exception.UserAlreadyExistException;
import com.SpringSecurityApp.data.user.UserData;
import com.SpringSecurityApp.entity.UserEntity;
import com.SpringSecurityApp.repository.UserRepository;
import com.SpringSecurityApp.service.UserService;

@Service("userService")
public class DefaultUserService implements UserService {

	@Autowired
	private UserRepository userRepository;

	@Autowired
	PasswordEncoder passwordEncoder;

	@Override
	public void register(UserData user) throws UserAlreadyExistException {

		// Let's check if user already registered with us
		if (checkIfUserExist(user.getEmail())) {
			throw new UserAlreadyExistException("User already exists for this email");
		}
		UserEntity userEntity = new UserEntity();
		BeanUtils.copyProperties(user, userEntity);
		encodePassword(userEntity, user);
		userRepository.save(userEntity);
	}

	@Override
	public boolean checkIfUserExist(String email) {
		return userRepository.findByEmail(email) != null ? true : false;
	}

	private void encodePassword(UserEntity userEntity, UserData user) {
		userEntity.setPassword(passwordEncoder.encode(user.getPassword()));
	}

}
