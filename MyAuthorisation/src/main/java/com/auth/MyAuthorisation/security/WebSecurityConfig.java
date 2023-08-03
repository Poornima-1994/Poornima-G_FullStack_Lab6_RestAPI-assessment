package com.auth.MyAuthorisation.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfiguration;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.auth.MyAuthorisation.service.UserDetailsServiceImpl;

@Configuration
@EnableWebSecurity 
public class WebSecurityConfig extends WebSecurityConfiguration
{
	
	protected void configure(AuthenticationManagerBuilder auth)throws Exception{
    auth.authenticationProvider(myAuth());		}
@Bean
private DaoAuthenticationProvider myAuth() {
	DaoAuthenticationProvider authProvider =new DaoAuthenticationProvider();
	authProvider.setUserDetailsService(myUser());
	authProvider.setPasswordEncoder(myPas());
		return authProvider ;
	}

@Bean
public BCryptPasswordEncoder myPas() {
	return new BCryptPasswordEncoder();
    
}
@Bean
public UserDetailsService myUser() {
		return new UserDetailsServiceImpl();
	}
}
