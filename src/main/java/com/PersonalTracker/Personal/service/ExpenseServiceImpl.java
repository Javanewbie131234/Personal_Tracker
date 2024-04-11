package com.PersonalTracker.Personal.service;

import com.PersonalTracker.Personal.Util.ExpenseUtilityDTOutil;
import com.PersonalTracker.Personal.dto.ExpenseDTO;
import com.PersonalTracker.Personal.entity.Expense;
import com.PersonalTracker.Personal.repository.ExpenseRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ExpenseServiceImpl implements ExpenseService {

    @Autowired
    ExpenseRepository expenseRepository;

    @Override
    public ExpenseDTO saveExpense(ExpenseDTO expenseDTO){
        Expense expense = processSaveExpense(new Expense(),expenseDTO);
        return ExpenseUtilityDTOutil.convertoDTO(expense);
    }


    private Expense processSaveExpense(Expense expense, ExpenseDTO expenseDTO){
//        iD is set internally
        expense.setDate(expenseDTO.date());
        expense.setAmount(expenseDTO.amount());
        expense.setTitle(expenseDTO.title());
        expense.setCategory(expenseDTO.category());
        expense.setDescription(expenseDTO.description());

        return expenseRepository.save(expense);


    }
    @Override
    public List<ExpenseDTO> getAllExpenses(){
        return expenseRepository.findAll()
                .stream()
                .sorted(Comparator.comparing(Expense::getDate).reversed())  //sorting by date, returns the latest on top
                .map(ExpenseUtilityDTOutil::convertoDTO)
                .collect(Collectors.toList());

    }
    @Override
    public ExpenseDTO getExpensebyId(Long id){
            ExpenseDTO optionalExpense = expenseRepository.findById(id)
                .map(ExpenseUtilityDTOutil::convertoDTO)
                .orElseThrow( ()-> new EntityNotFoundException("User not found with Id " + id));
//        Write a custom exception for USERNOTFOUND
                return optionalExpense;


    }
    @Override
    public ExpenseDTO updateExpense(Long id, ExpenseDTO dto){
        Optional<Expense> optionalExpense = expenseRepository.findById(id);
        if(optionalExpense.isPresent()){
            return ExpenseUtilityDTOutil.convertoDTO(processSaveExpense(optionalExpense.get(),dto));
        }else {
            throw new EntityNotFoundException("Expense not found with id "+id);
        }

    }
    @Override
    public void deleteExpense(long id){
        Optional<Expense> optionalExpense = expenseRepository.findById(id);
        if(optionalExpense.isPresent()){
            expenseRepository.deleteById(id);
        }else {
            throw new EntityNotFoundException("Expense is not present with this id "+ id);
        }

    }




}
