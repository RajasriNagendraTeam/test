package com.rs.fer.controller;

import java.util.Set;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.rs.fer.exception.ResourceNotFoundException;
import com.rs.fer.model.Expense;
import com.rs.fer.repository.ExpenseRepository;
import com.rs.fer.request.RegistrationVO;
import com.rs.fer.response.AddExpenseResponse;
import com.rs.fer.response.EditExpenseResponse;
import com.rs.fer.response.GetExpenseResponse;
import com.rs.fer.response.GetExpensesResponse;
import com.rs.fer.response.LoginResponse;
import com.rs.fer.response.RegistrationResponse;
import com.rs.fer.response.ExpenseReportResponse;
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

	@PostMapping("/register")
	public RegistrationResponse userRegistration(@Valid @ModelAttribute RegistrationVO registrationVO) {

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
	public AddExpenseResponse addExpense(@Valid @ModelAttribute Expense expense) {
		return ferService.addExpense(expense);
	}

	@PutMapping("/expense/{id}")
	public EditExpenseResponse editExpense(@PathVariable("id") Integer Id, @Valid @ModelAttribute Expense expense) {
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
			return ferService.expenseReport(userId,type, fromDate, toDate);
		}
	}

	@DeleteMapping("/expense/{expenseId}")
	public ResponseEntity<?> deleteExpense(@PathVariable(value = "expenseId") int expenseId) {
		Expense exp = expenseRepository.findById(expenseId)
				.orElseThrow(() -> new ResourceNotFoundException("Expense", "expenseId", expenseId));
		expenseRepository.delete(exp);
		return ResponseEntity.ok().build();
	}

	/*
	 * @PutMapping("/reset/{id}") public User reset(@PathVariable(value = "id")
	 * Integer id, @Valid @RequestBody User u) { User user =
	 * userRepository.findById(id).orElseThrow(() -> new
	 * ResourceNotFoundException("User", "id", id));
	 * user.setUserName(u.getUserName()); user.setPassword(u.getPassword()); return
	 * userRepository.save(user); }
	 * 
	 * @GetMapping("/getExpense/{expenseId}") public Expense
	 * getExpense(@PathVariable(value = "expenseId") int expenseId) { return
	 * expenseRepository.findById(expenseId) .orElseThrow(() -> new
	 * ResourceNotFoundException("Expense", "expenseId", expenseId)); }
	 * 
	 * @GetMapping("/getExpenses/{userId}") public List<Expense>
	 * getExpenses(@PathVariable(value = "userId") Iterable<Integer> userId) {
	 * return (List<Expense>) expenseRepository.findAllById(userId); }
	 * 
	 * @GetMapping("/getUser/{id}") public User getUser(@PathVariable(value = "id")
	 * Integer id) { return userRepository.findById(id).orElseThrow(() -> new
	 * ResourceNotFoundException("User", "id", id)); }
	 * 
	 * @GetMapping("/updateUser/{id}") public User updateUser(@PathVariable(value =
	 * "id") Integer id, @Valid @RequestBody User user) {
	 * 
	 * User u = userRepository.findById(id) .orElseThrow(() -> new
	 * ResourceNotFoundException("User", "id", id));
	 * u.setFirstName(user.getFirstName()); u.setMiddleName(user.getMiddleName());
	 * u.setLastName(user.getLastName()); u.setEmail(user.getEmail());
	 * u.setMobile(user.getMobile()); u.getUserName();
	 * u.setAddress(user.getAddress()); return userRepository.save(u); }
	 * 
	 * @PutMapping("/expenseReport") public List<Expense>
	 * expenseReport(@PathVariable int userId, String
	 * 
	 * @Valid @RequestBody Expense exp) { List<Expense> expense=(List<Expense>)
	 * expenseRepository.findById(userId) .orElseThrow(() -> new
	 * ResourceNotFoundException("expenseType", "fromDate", "toDate"));
	 * expense.set(0,expenseType); expense.set(1, fromDate); expense.set(2, toDate);
	 * }
	 */

}
