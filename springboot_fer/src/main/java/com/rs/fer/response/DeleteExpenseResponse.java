package com.rs.fer.response;

import java.util.List;
import java.util.Set;

import org.springframework.http.HttpStatus;

import com.rs.fer.model.Expense;

public class DeleteExpenseResponse extends AbstractResponse {

	public DeleteExpenseResponse() {

	}

	public DeleteExpenseResponse(HttpStatus status, String statusCode, Set<String> errorMessages) {
		super.setStatus(status);
		super.setStatusCode(statusCode);
		super.setErrorMessages(errorMessages);
	}

}
