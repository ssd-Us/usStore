package com.example.usStore.controller.mypage;

import org.hibernate.validator.constraints.NotEmpty;
//////////////////////////
//중간고사 대첵과제 코드 복붙
/////////////////////////
public class LoginCommand {

	@NotEmpty	
	private String userId;
	@NotEmpty	
	private String password;
	private String forwardAction;
	
	public LoginCommand() {}
	
	public LoginCommand(String userId) {
		this.userId = userId;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getForwardAction() {
		return forwardAction;
	}

	public void setForwardAction(String forwardAction) {
		this.forwardAction = forwardAction;
	}

}
