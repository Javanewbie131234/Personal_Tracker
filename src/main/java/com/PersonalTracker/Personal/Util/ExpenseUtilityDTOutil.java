package com.PersonalTracker.Personal.Util;

import com.PersonalTracker.Personal.dto.ExpenseDTO;
import com.PersonalTracker.Personal.entity.Expense;

public class ExpenseUtilityDTOutil {

    public static ExpenseDTO convertoDTO(Expense expense){
        ExpenseDTO dto =new ExpenseDTO(
                expense.getId(),
                expense.getTitle(),
                expense.getDescription(),
                expense.getCategory(),
                expense.getDate(),
                expense.getAmount()
        );
         return dto;

    }

    public static Expense convertToEntity(ExpenseDTO dto){
        Expense expense = new Expense();
                expense.setId(dto.id());
                expense.setTitle(dto.title());
                expense.setDescription(dto.description());
                expense.setCategory(dto.category());
                expense.setDate(dto.date());
                expense.setAmount(dto.amount());

        return expense;
    }

}
