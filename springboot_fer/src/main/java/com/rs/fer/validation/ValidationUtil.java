package com.rs.fer.validation;

import java.util.Set;

import com.rs.fer.request.RegistrationVO;

public interface ValidationUtil {
	Set<String> validateRegistrationRequest(RegistrationVO registrationVO);
	Set<String> validateGetExpenseRequest(int expenseId);
	Set<String> validateGetExpensesRequest(int userId);
	

}
