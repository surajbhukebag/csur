package com.cmpe275.project.CSUR.mapper;

import com.cmpe275.project.CSUR.model.User;

public class UserResponse {
	
	private String msg;
	
	
	private User user;


	public String getMsg() {
		return msg;
	}


	public void setMsg(String msg) {
		this.msg = msg;
	}


	public User getUser() {
		return user;
	}


	public void setUser(User user) {
		this.user = user;
	}
}
