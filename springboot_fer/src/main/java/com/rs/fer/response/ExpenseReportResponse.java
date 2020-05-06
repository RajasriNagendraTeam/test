package com.rs.fer.response;

import java.util.List;
import java.util.Set;

import org.springframework.http.HttpStatus;

import com.rs.fer.model.Expense;

public class ExpenseReportResponse extends AbstractResponse {

	private List<Expense> expenses;

	public ExpenseReportResponse() {

	}

	public ExpenseReportResponse(HttpStatus status, String statusCode, Set<String> errorMessages) {
		super.setStatus(status);
		super.setStatusCode(statusCode);
		super.setErrorMessages(errorMessages);
	}

	public List<Expense> getExpenses() {
		return expenses;
	}

	public void setExpenses(List<Expense> expenses) {
		this.expenses = expenses;
	}

}
