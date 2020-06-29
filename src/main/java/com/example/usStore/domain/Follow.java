package com.example.usStore.domain;

import java.io.Serializable;

/*
 * Mypage - Follow Domain Class
 * */
@SuppressWarnings("serial")
public class Follow  implements Serializable {
	private String follower; 	// (FK) userId
	private String following;	// (FK) userId
	
	// Constructor
	public Follow() {
		
	}
	
	// getter & setter
	public String getFollower() {
		return follower;
	}
	public void setFollower(String follower) {
		this.follower = follower;
	}
	public String getFollowing() {
		return following;
	}
	public void setFollowing(String following) {
		this.following = following;
	}
}
