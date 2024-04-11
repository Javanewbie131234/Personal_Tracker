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
        Expense expense = new Expense(
                dto.id(),
                dto.title(),
                dto.description(),
                dto.category(),
                dto.date(),
                dto.amount()
        );
        return expense;
    }

}
