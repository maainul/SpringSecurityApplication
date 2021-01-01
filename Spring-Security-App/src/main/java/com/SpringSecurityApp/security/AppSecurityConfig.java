package com.SpringSecurityApp.security;

import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@EnableWebSecurity
public class AppSecurityConfig extends WebSecurityConfigurerAdapter {

	
	@Override
	protected void configure(HttpSecurity http)throws Exception{
		http
		.authorizeRequests()
		.antMatchers("/login", "/register").permitAll()
		.antMatchers("/account/**").hasAuthority("USER")
		.and()
		.formLogin().and()
		.httpBasic();
	}
	
	
	@Override
	public void configure(AuthenticationManagerBuilder auth) throws Exception{
		auth.inMemoryAuthentication()
		.withUser("admin")
		.password("{noop}123")
		.authorities("USER");
		
	}
}