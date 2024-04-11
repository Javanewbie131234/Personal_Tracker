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
        Income income = new Income();
                income.setId(incomeDTO.id());
                income.setTitle(incomeDTO.title());
                income.setAmount(incomeDTO.amount());
                income.setDate(incomeDTO.date());
                income.setCategory(incomeDTO.category());
                income.setDescription(incomeDTO.description());

        return income;
    }


}
