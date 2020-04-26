package com.example.usStore.domain;

/*
 * Mypage Function - Follow
 * */
public class Follow {
	private String follower; 	// 다른 사용자를 팔로우하려는 사용자의 id
	private String following;	// 사용자가 팔로잉하려는 다른 사용자의 id
	
	// 기본 생성자
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
