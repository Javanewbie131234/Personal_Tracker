package com.PersonalTracker.Personal.service;

import com.PersonalTracker.Personal.dto.ExpenseDTO;

import java.util.List;

public interface ExpenseService {
    public ExpenseDTO saveExpense(ExpenseDTO expenseDTO);
    List<ExpenseDTO> getAllExpenses();
    ExpenseDTO getExpensebyId(Long id);
    ExpenseDTO updateExpense(Long id, ExpenseDTO dto);

    void deleteExpense(long id);

}
