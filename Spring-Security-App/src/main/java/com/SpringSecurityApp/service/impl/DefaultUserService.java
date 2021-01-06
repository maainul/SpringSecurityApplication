package com.SpringSecurityApp.service.impl;

import java.util.Objects;

import javax.mail.MessagingException;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.SpringSecurityApp.context.AccountVerificationEmailContext;
import com.SpringSecurityApp.core.exception.InvalidTokenException;
import com.SpringSecurityApp.core.exception.UserAlreadyExistException;
import com.SpringSecurityApp.data.user.UserData;
import com.SpringSecurityApp.entity.UserEntity;
import com.SpringSecurityApp.repository.SecureTokenRepository;
import com.SpringSecurityApp.repository.UserRepository;
import com.SpringSecurityApp.security.jpa.SecureToken;
import com.SpringSecurityApp.service.EmailService;
import com.SpringSecurityApp.service.SecureTokenService;
import com.SpringSecurityApp.service.UserService;

@Service("userService")

public class DefaultUserService implements UserService {

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private PasswordEncoder passwordEncoder;

	@Autowired
	private EmailService emailService;

	@Autowired
	private SecureTokenService secureTokenService;

	@Autowired
	SecureTokenRepository secureTokenRepository;

	@Value("${site.base.url.https}")
	private String baseURL;

	@Override
	public void register(UserData user) throws UserAlreadyExistException {
		if (checkIfUserExist(user.getEmail())) {
			throw new UserAlreadyExistException("User already exists for this email");
		}
		UserEntity userEntity = new UserEntity();
		BeanUtils.copyProperties(user, userEntity);
		encodePassword(user, userEntity);
		userRepository.save(userEntity);
		sendRegistrationConfirmationEmail(userEntity);

	}

	@Override
	public void sendRegistrationConfirmationEmail(UserEntity user) {
		SecureToken secureToken = secureTokenService.createSecureToken();
		secureToken.setUser(user);
		secureTokenRepository.save(secureToken);
		AccountVerificationEmailContext emailContext = new AccountVerificationEmailContext();
		emailContext.init(user);
		emailContext.setToken(secureToken.getToken());
		emailContext.buildVerificationUrl(baseURL, secureToken.getToken());
		try {
			emailService.sendMail(emailContext);
		} catch (MessagingException e) {
			e.printStackTrace();
		}

	}

	private void encodePassword(UserData source, UserEntity target) {
		target.setPassword(passwordEncoder.encode(source.getPassword()));
	}

	@Override
	public boolean checkIfUserExist(String email) {
		return userRepository.findByEmail(email) != null ? true : false;
	}

	@Override
	public boolean verifyUser(String token) throws InvalidTokenException {
		SecureToken secureToken = secureTokenService.findByToken(token);
		if (Objects.isNull(secureToken) || !StringUtils.equals(token, secureToken.getToken())
				|| secureToken.isExpired()) {
			throw new InvalidTokenException("Token is not valid");
		}
		UserEntity user = userRepository.getOne(secureToken.getUser().getId());
		if (Objects.isNull(user)) {
			return false;
		}
		user.setAccountVerified(true);
		userRepository.save(user); // let’s same user details

		// we don’t need invalid password now
		secureTokenService.removeToken(secureToken);
		return true;
	}

}