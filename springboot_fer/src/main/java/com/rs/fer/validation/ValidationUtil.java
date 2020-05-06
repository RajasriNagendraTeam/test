package com.rs.fer.validation;

import java.util.Set;

import com.rs.fer.request.RegistrationVO;

public interface ValidationUtil {
	Set<String> validateRegistrationRequest(RegistrationVO registrationVO);

	Set<String> validateGetExpenseRequest(int expenseId);

	Set<String> validateGetExpensesRequest(int userId);

	Set<String> validateExpenseReportRequest(int userId, String type, String fromdate, String toDate);

	Set<String> validateResetPasswordRequest(int userId, String currentPassword, String newPassword);
}
