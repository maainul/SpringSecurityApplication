package com.SpringSecurityApp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.SpringSecurityApp.security.jpa.SecureToken;

@Repository
public interface SecureTokenRepository extends JpaRepository<SecureToken, Long> {
	
	SecureToken findByToken(final String token);
	Long removeByToken(String token);
}
