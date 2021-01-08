package com.SpringSecurityApp.service;

import com.SpringSecurityApp.core.exception.InvalidTokenException;
import com.SpringSecurityApp.core.exception.UnkownIdentifierException;

public interface CustomerAccountService {
	void forgottenPassword(final String userName) throws UnkownIdentifierException;
    void updatePassword(final String password, final String token) throws InvalidTokenException, UnkownIdentifierException;
}
