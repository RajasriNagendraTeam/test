package com.rs.fer.response;

import java.util.Set;

import org.springframework.http.HttpStatus;

import com.rs.fer.model.User;

public class UpdateUserResponse extends AbstractResponse {

	private User user;

	public UpdateUserResponse() {

	}

	public UpdateUserResponse(HttpStatus status, String statusCode, Set<String> errorMessages) {
		super.setStatus(status);
		super.setStatusCode(statusCode);
		super.setErrorMessages(errorMessages);
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

}
