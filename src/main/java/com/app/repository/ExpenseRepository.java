package com.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.app.model.Expense;
@Repository
public interface ExpenseRepository extends JpaRepository<Expense, Integer>{

}
