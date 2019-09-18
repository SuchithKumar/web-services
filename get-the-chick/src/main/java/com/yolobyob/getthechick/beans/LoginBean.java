package com.yolobyob.getthechick.beans;

import javax.validation.constraints.NotNull;

import org.springframework.stereotype.Component;

import com.yolobyob.getthechick.enums.UserType;

@Component
public class LoginBean {

	@NotNull(message = "userType cannot be null")
	private UserType userType;
	
	@NotNull(message = "userId cannot be null")
	private String userId;
	
	@NotNull(message = "password cannot be null")
	private String password;
	
	public LoginBean() {
		
	}

	public LoginBean(@NotNull(message = "userType cannot be null") UserType userType, @NotNull(message = "userId cannot be null") String userId,
			@NotNull(message = "password cannot be null") String password) {
		super();
		this.userType = userType;
		this.userId = userId;
		this.password = password;
	}

	public UserType getUserType() {
		return userType;
	}

	public void setUserType(UserType userType) {
		this.userType = userType;
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
	
	


}
