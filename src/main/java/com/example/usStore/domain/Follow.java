package com.example.usStore.domain;

/*
 * Mypage Function - Follow
 * */
public class Follow {
	private String follower; 	// �ٸ� ����ڸ� �ȷο��Ϸ��� ������� id
	private String following;	// ����ڰ� �ȷ����Ϸ��� �ٸ� ������� id
	
	// �⺻ ������
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
