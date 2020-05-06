package com.rs.fer.service;

import com.rs.fer.model.Expense;
import com.rs.fer.request.RegistrationVO;
import com.rs.fer.response.AddExpenseResponse;
import com.rs.fer.response.EditExpenseResponse;
import com.rs.fer.response.GetExpenseResponse;
import com.rs.fer.response.GetExpensesResponse;
import com.rs.fer.response.LoginResponse;
import com.rs.fer.response.RegistrationResponse;
import com.rs.fer.response.ExpenseReportResponse;

public interface FERService {
	RegistrationResponse registration(RegistrationVO registrationVO);
	
	LoginResponse login(String userName, String password);
	
	AddExpenseResponse addExpense(Expense expense);
	
	EditExpenseResponse editExpense(Expense expense);
	
	GetExpenseResponse getExpenseById(Integer id);
	
	GetExpensesResponse getExpenses(Integer userId);
	
	ExpenseReportResponse expenseReport( int userid,String type,String fromdate,String toDate);
}

	

