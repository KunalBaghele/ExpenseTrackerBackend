package com.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.model.Expense;
import com.app.repository.ExpenseRepository;
import com.app.service.ExpenseService;

@RestController
@RequestMapping("api/expenses")
public class ExpenceController {
	 @Autowired
	    private ExpenseService expenseService;
	 
	 @Autowired
	 private ExpenseRepository expenseRepository;

	 	@GetMapping
	 	public List<Expense> getAllExpences() {
	 		return expenseRepository.findAll();
	 	}
	 	
	    @PostMapping("/add")
	    public void addExpense(@RequestBody Expense expense) {
	        expenseService.addExpense(expense);
	    }
	    
	    @DeleteMapping("/{id}")
	    public void deleteExpenseById(@PathVariable int id) {
	    	expenseRepository.deleteById(id);
	    }
}
