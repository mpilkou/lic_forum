package ug.edu.entity;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class MyUser {
	@NotNull(message="required field")
	@Size(min=3, message="required field")	
	private String userName;
	
	@NotNull(message="required field")
	@Size(min=3, message="required field")
	private String password;

	public MyUser() {
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
	
}
