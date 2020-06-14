package com.example.usStore.domain;

import java.io.Serializable;

/*
 * Account Domain Class
 * */
@SuppressWarnings("serial")
public class Account implements Serializable {

    /* Private Fields */
    private String userId;
    private String password;
    private String email;
    private String username; 
    private String address1;
    private String address2;
    private String city;
    private String status;
    private String zip;
    private String country;
    private String phone;
    private String unniversity;

  	/* JavaBeans Properties */
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
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getAddress1() {
		return address1;
	}
	public void setAddress1(String address1) {
		this.address1 = address1;
	}
	public String getAddress2() {
		return address2;
	}
	public void setAddress2(String address2) {
		this.address2 = address2;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getZip() {
		return zip;
	}
	public void setZip(String zip) {
		this.zip = zip;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getUnniversity() {
		return unniversity;
	}
	public void setUnniversity(String unniversity) {
		this.unniversity = unniversity;
	}
}
