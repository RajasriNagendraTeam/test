package com.rs.fer.controller;

import java.util.Set;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.rs.fer.model.Expense;
import com.rs.fer.model.User;
import com.rs.fer.repository.ExpenseRepository;
import com.rs.fer.request.RegistrationVO;
import com.rs.fer.response.AddExpenseResponse;
import com.rs.fer.response.DeleteExpenseResponse;
import com.rs.fer.response.EditExpenseResponse;
import com.rs.fer.response.ExpenseReportResponse;
import com.rs.fer.response.GetExpenseResponse;
import com.rs.fer.response.GetExpensesResponse;
import com.rs.fer.response.GetUserResponse;
import com.rs.fer.response.LoginResponse;
import com.rs.fer.response.RegistrationResponse;
import com.rs.fer.response.ResetPasswordResponse;
import com.rs.fer.response.UpdateUserResponse;
import com.rs.fer.service.FERService;
import com.rs.fer.validation.ValidationUtil;


@RestController
@RequestMapping("/api")
public class FERController {
	@Autowired
	FERService ferService;

	@Autowired
	ValidationUtil validationUtil;

	@Autowired
	ExpenseRepository expenseRepository;

	private Integer expensseId;

	@PostMapping("/register")
	public RegistrationResponse userRegistration(@Valid @RequestBody RegistrationVO registrationVO) {

		Set<String> errorMessages = validationUtil.validateRegistrationRequest(registrationVO);
		if (!CollectionUtils.isEmpty(errorMessages)) {
			return new RegistrationResponse(HttpStatus.PRECONDITION_FAILED, "999", errorMessages);
		} else {
			return ferService.registration(registrationVO);
		}
	}

	@PostMapping("/login")
	public LoginResponse login(@RequestParam String userName, @RequestParam String password) {
		return ferService.login(userName, password);
	}

	@PostMapping("/expense")
	public AddExpenseResponse addExpense(@Valid @RequestBody Expense expense) {
		return ferService.addExpense(expense);
	}

	@PutMapping("/expense/{id}")
	public EditExpenseResponse editExpense(@PathVariable("id") Integer Id, @Valid @RequestBody Expense expense) {
		return ferService.editExpense(expense);
	}

	@GetMapping("/expense/{id}")
	public GetExpenseResponse getExpenseById(@PathVariable("id") Integer id) {
		Set<String> errorMessages = validationUtil.validateGetExpenseRequest(id);
		if (!CollectionUtils.isEmpty(errorMessages)) {
			return new GetExpenseResponse(HttpStatus.PRECONDITION_FAILED, "999", errorMessages);
		} else {
			return ferService.getExpenseById(id);
		}
	}

	@GetMapping("/expenses/{userId}")
	public GetExpensesResponse getExpenses(@PathVariable("userId") Integer userId) {
		Set<String> errorMessages = validationUtil.validateGetExpensesRequest(userId);
		if (!CollectionUtils.isEmpty(errorMessages)) {
			return new GetExpensesResponse(HttpStatus.PRECONDITION_FAILED, "999", errorMessages);
		} else {
			return ferService.getExpenses(userId);
		}
	}

	@GetMapping("/{userId}/expense/report")
	public ExpenseReportResponse expenseReport(@PathVariable("userId") Integer userId, @RequestParam String type,
			@RequestParam String fromDate, @RequestParam String toDate) {
		Set<String> errorMessages = validationUtil.validateExpenseReportRequest(userId, type, fromDate, toDate);
		if (!CollectionUtils.isEmpty(errorMessages)) {
			return new ExpenseReportResponse(HttpStatus.PRECONDITION_FAILED, "999", errorMessages);
		} else {
			return ferService.expenseReport(userId, type, fromDate, toDate);
		}
	}

	@DeleteMapping("/expense/{expenseId}")
	public DeleteExpenseResponse deleteExpense(@PathVariable(value = "expenseId") int expenseId) {
		Set<String> errorMessages = validationUtil.validateDeleteExpenseRequest(expenseId);
		if (!CollectionUtils.isEmpty(errorMessages)) {
			return new DeleteExpenseResponse(HttpStatus.PRECONDITION_FAILED, "999", errorMessages);
		} else {
			return ferService.deleteExpense(expensseId);
		}
	}

	@PutMapping("/reset/{userId}")
	public ResetPasswordResponse reset(@PathVariable(value = "userId") int userId, @RequestParam String currentPassword,
			@RequestParam String newPassword) {
		Set<String> errorMessages = validationUtil.validateResetPasswordRequest(userId, currentPassword, newPassword);
		if (!CollectionUtils.isEmpty(errorMessages)) {
			return new ResetPasswordResponse(HttpStatus.PRECONDITION_FAILED, "999", errorMessages);
		} else {
			return ferService.resetPassword(userId, currentPassword, newPassword);
		}
	}

	@GetMapping("/user/{id}")
	public GetUserResponse getUser(@PathVariable("id") Integer id) {
		Set<String> errorMessages = validationUtil.validateGetUserRequest(id);
		if (!CollectionUtils.isEmpty(errorMessages)) {
			return new GetUserResponse(HttpStatus.PRECONDITION_FAILED, "999", errorMessages);
		} else {
			return ferService.getUser(id);
		}
	}
	
	@PutMapping("/user")
	public UpdateUserResponse update(@RequestBody User user) {
		Set<String> errorMessages = validationUtil.validateUpdateUserRequest(user);
		if (!CollectionUtils.isEmpty(errorMessages)) {
			return new UpdateUserResponse(HttpStatus.PRECONDITION_FAILED, "999", errorMessages);
		} else {
			return ferService.updateUser(user);
		}
	}

	
}
