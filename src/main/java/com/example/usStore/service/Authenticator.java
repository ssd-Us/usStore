package com.example.usStore.service;
//////////////////////////
//중간고사 대첵과제 코드 복붙
/////////////////////////

import com.example.usStore.controller.mypage.LoginCommand;

public interface Authenticator {

	void authenticate(LoginCommand loginCommand)
			throws AuthenticationException;

}
