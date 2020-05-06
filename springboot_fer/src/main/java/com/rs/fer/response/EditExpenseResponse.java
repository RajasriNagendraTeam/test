package com.rs.fer.response;

import com.rs.fer.model.Expense;
import com.rs.fer.model.User;

public class EditExpenseResponse extends AbstractResponse {
	
	private Expense expense;
	
	public Expense getExpense() {
		return expense;
	}
	public void setExpense(Expense expense) {
		this.expense = expense;
	}
	
	
}
