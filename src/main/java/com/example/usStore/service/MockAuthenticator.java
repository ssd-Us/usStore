package com.example.usStore.service;
//////////////////////////
//중간고사 대첵과제 코드 복붙
/////////////////////////

import org.springframework.stereotype.Service;
import com.example.usStore.controller.mypage.LoginCommand;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Service
public class MockAuthenticator implements Authenticator {

	static final Logger LOGGER = LoggerFactory.getLogger(MockAuthenticator.class);
	
	@Override
	public void authenticate(LoginCommand loginCommand)
			throws AuthenticationException {
		if (!loginCommand.getUserId().equals(loginCommand.getPassword())) {
	        LOGGER.info("인증 에러: userId is {}, password is {} ", 
	        	loginCommand.getUserId(), loginCommand.getPassword());
			throw new AuthenticationException();
		}
	}
}
