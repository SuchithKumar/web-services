package com.yolobyob.getthechick.beans;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;

import org.springframework.stereotype.Component;

import com.yolobyob.getthechick.enums.UserType;

@Component
public class RegisterBean {

	@NotNull
	private UserType userType;
	
	@NotNull
	private  String userName;
	
	@NotNull(message = "Password cannot be null")
	private String password;
	
	@NotNull(message = "Phone cannot be null")
	private String phone;
	
	@NotNull(message = "Email ID cannot be null")
	@Email(message = "Email ID should be valid")
	private String emailId;
	
	public RegisterBean() {
		
	}
	
	public RegisterBean(@NotNull(message = "User Type cannot be null") UserType userType,
			@NotNull(message = "User Name cannot be null") String userName,
			@NotNull(message = "Password cannot be null") String password,
			@NotNull(message = "Phone cannot be null") String phone,
			@NotNull(message = "Email ID cannot be null") @Email(message = "Email ID should be valid") String emailId) {
		super();
		this.userType = userType;
		this.userName = userName;
		this.password = password;
		this.phone = phone;
		this.emailId = emailId;
	}



	public UserType getUserType() {
		return userType;
	}

	public void setUserType(UserType userType) {
		this.userType = userType;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	@Override
	public String toString() {
		return "RegisterBean [type=" + userType + ", customerName=" + userName + ", password=" + password + ", phone="
				+ phone + ", emailId=" + emailId + "]";
	}

}
