package com.SpringSecurityApp.service.impl;

import java.util.Objects;

import javax.mail.MessagingException;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.SpringSecurityApp.context.ForgotPasswordEmailContext;
import com.SpringSecurityApp.core.exception.InvalidTokenException;
import com.SpringSecurityApp.core.exception.UnkownIdentifierException;
import com.SpringSecurityApp.entity.UserEntity;
import com.SpringSecurityApp.repository.SecureTokenRepository;
import com.SpringSecurityApp.repository.UserRepository;
import com.SpringSecurityApp.security.jpa.SecureToken;
import com.SpringSecurityApp.service.CustomerAccountService;
import com.SpringSecurityApp.service.EmailService;
import com.SpringSecurityApp.service.SecureTokenService;
import com.SpringSecurityApp.service.UserService;

@Service("customerAccountService")
public class DefaultCustomerAccountService implements CustomerAccountService{

    @Autowired
    UserService userService;

    @Autowired
    private SecureTokenService secureTokenService;

    @Autowired
    SecureTokenRepository secureTokenRepository;

    @Value("${site.base.url.https}")
    private String baseURL;

    @Autowired
    private EmailService emailService;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;


    @Override
    public void forgottenPassword(String userName) throws UnkownIdentifierException {
        UserEntity user= userService.getUserById(userName);
        sendResetPasswordEmail(user);
    }

    @Override
    public void updatePassword(String password, String token) throws InvalidTokenException, UnkownIdentifierException {
        SecureToken secureToken = secureTokenService.findByToken(token);
        if(Objects.isNull(secureToken) || !StringUtils.equals(token, secureToken.getToken()) || secureToken.isExpired()){
            throw new InvalidTokenException("Token is not valid");
        }
        UserEntity user = userRepository.getOne(secureToken.getUser().getId());
        if(Objects.isNull(user)){
            throw new UnkownIdentifierException("unable to find user for the token");
        }
        secureTokenService.removeToken(secureToken);
        user.setPassword(passwordEncoder.encode(password));
        userRepository.save(user);
    }

    protected void sendResetPasswordEmail(UserEntity user) {
        SecureToken secureToken= secureTokenService.createSecureToken();
        secureToken.setUser(user);
        secureTokenRepository.save(secureToken);
        ForgotPasswordEmailContext emailContext = new ForgotPasswordEmailContext();
        emailContext.init(user);
        emailContext.setToken(secureToken.getToken());
        emailContext.buildVerificationUrl(baseURL, secureToken.getToken());
        try {
            emailService.sendMail(emailContext);
        } catch (MessagingException e) {
            e.printStackTrace();
        }
    }
}
