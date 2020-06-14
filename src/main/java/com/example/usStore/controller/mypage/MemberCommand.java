package com.example.usStore.controller.mypage;

import javax.validation.Valid;
import javax.validation.constraints.AssertTrue;
import javax.validation.constraints.Max;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;
//////////////////////////
//중간고사 대첵과제 코드 복붙
/////////////////////////
public class MemberCommand {
	@NotEmpty @Email
	private String id;
	@NotEmpty	
	private String name;
	@NotEmpty @Size(min=6)
	private String password;
	@NotEmpty
	private String confirmPassword;
	@NotEmpty @Pattern(regexp = "01[01679]-\\d{3,4}-\\d{4}")
	private String phone;
	@NotEmpty
	private String title;
	@Max(30)
	private int length;
	private boolean newPerformer;
	//@AssertTrue
	//private boolean samePasswordConfirmPassword;
		
	public MemberCommand(MemberInfo mi) {
		if (mi != null) {
			id = mi.getId();  
			name = mi.getName();  
			password = mi.getPassword();
			confirmPassword = null;
			phone = mi.getPhone();
			title = mi.getTitle(); 
			length = mi.getLength();
			newPerformer = mi.isNewPerformer();
		}
	}

	public MemberCommand() {}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getConfirmPassword() {
		return confirmPassword;
	}

	public void setConfirmPassword(String confirmPassword) {
		this.confirmPassword = confirmPassword;
	}
	
	@AssertTrue
	public boolean isSamePasswordConfirmPassword() {
		if (password == null || confirmPassword == null)
			return false;
		return password.equals(confirmPassword);
	}

	public boolean hasPassword() {
		return password != null && password.trim().length() > 0;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public int getLength() {
		return length;
	}

	public void setLength(int length) {
		this.length = length;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}
	
	public boolean isNewPerformer() {
		return newPerformer;
	}

	public void setNewPerformer(boolean newPerformer) {
		this.newPerformer = newPerformer;
	}

	@Override
	public String toString() {
		return "MemberCommand [id=" + id + ", name=" + name + ", password=" + password + ", confirmPassword=" + confirmPassword
				+ ", phone=" + phone + ", title=" + title + ", length="
				+ length + ", newPerformer=" + newPerformer + "]";
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}	
}
