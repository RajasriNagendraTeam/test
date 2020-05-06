package com.rs.fer.response;

import java.util.Set;

import org.springframework.http.HttpStatus;

import com.rs.fer.model.User;

public class GetUserResponse extends AbstractResponse {

	public GetUserResponse() {

	}

	public GetUserResponse(HttpStatus status, String statusCode, Set<String> errorMessages) {
		super.setStatus(status);
		super.setStatusCode(statusCode);
		super.setErrorMessages(errorMessages);
	}

	private User user;

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

}
