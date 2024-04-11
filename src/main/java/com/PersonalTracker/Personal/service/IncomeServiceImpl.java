package com.PersonalTracker.Personal.service;

import com.PersonalTracker.Personal.Util.IncomeUtility;
import com.PersonalTracker.Personal.dto.IncomeDTO;
import com.PersonalTracker.Personal.entity.Income;
import com.PersonalTracker.Personal.repository.IncomeRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class IncomeServiceImpl implements IncomeService{

    @Autowired
    IncomeRepository incomeRepository;
//    Can use private final also ??
    @Override
    public IncomeDTO saveIncome(IncomeDTO incomeDTO){
        Income income = new Income();
        income.setAmount(incomeDTO.amount());
        income.setDate(incomeDTO.date());
        income.setCategory(incomeDTO.category());
        income.setTitle(incomeDTO.title());
        income.setDescription(incomeDTO.description())  ;
        return IncomeUtility.convertToDTO(incomeRepository.save(income));
    }

    @Override
    public List<IncomeDTO> getAllIncome() {
        return incomeRepository.findAll()
                .stream()
                .sorted(Comparator.comparing(Income::getDate).reversed())
                .map(IncomeUtility::convertToDTO)
                .collect(Collectors.toList());

    }

    @Override
    public IncomeDTO updateIncome(Long id, IncomeDTO incomeDTO) {
        Income existingIncome = incomeRepository.findById(id)
                .orElseThrow( ()-> new EntityNotFoundException("Entity not found with id "+ id));
        if(existingIncome!=null) {
            existingIncome.setDescription(incomeDTO.description());
            existingIncome.setAmount(incomeDTO.amount());
            existingIncome.setDate(incomeDTO.date());
            existingIncome.setCategory(incomeDTO.category());
            existingIncome.setTitle(incomeDTO.title());
            incomeRepository.save(existingIncome);
        }else {
            throw new EntityNotFoundException("Entity not found with Id "+id);
        }
        return IncomeUtility.convertToDTO(existingIncome);
    }

    @Override
    public IncomeDTO getById(long id) {
        return incomeRepository.findById(id)
                .map(IncomeUtility::convertToDTO)
                .orElseThrow(() -> new EntityNotFoundException("Entity with not found with ID " + id));
    }

    @Override
    public void deleteIncome(Long id) {
        Optional<Income> deleteIncome = incomeRepository.findById(id);
        if(deleteIncome.isPresent()){
            incomeRepository.deleteById(id);
        } else {
            throw new EntityNotFoundException("Entity not Found with id"+ id);
        }

    }

}
