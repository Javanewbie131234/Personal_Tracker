package com.PersonalTracker.Personal.service;

import com.PersonalTracker.Personal.dto.IncomeDTO;

import java.util.List;

public interface IncomeService {

    IncomeDTO saveIncome(IncomeDTO incomeDTO);
    List<IncomeDTO> getAllIncome();
    IncomeDTO updateIncome(Long id, IncomeDTO incomeDTO);
    IncomeDTO getById(long id);
    void deleteIncome(Long id);

}
