package com.PersonalTracker.Personal.Util;

import com.PersonalTracker.Personal.dto.IncomeDTO;
import com.PersonalTracker.Personal.entity.Income;

public class IncomeUtility {

    public static IncomeDTO convertToDTO(Income income){
        IncomeDTO incomeDTO = new IncomeDTO(
                income.getId(),
                income.getTitle(),
                income.getAmount(),
                income.getCategory(),
                income.getDescription(),
                income.getDate()
        );
        return  incomeDTO;
    }

    public static Income convertToEntity(IncomeDTO incomeDTO){
        Income income = new Income(
                incomeDTO.id(),
                incomeDTO.title(),
                incomeDTO.amount(),
                incomeDTO.date(),
                incomeDTO.category(),
                incomeDTO.description()
        );
        return income;
    }


}
