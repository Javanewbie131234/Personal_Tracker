package com.PersonalTracker.Personal.controller;

import com.PersonalTracker.Personal.dto.IncomeDTO;
import com.PersonalTracker.Personal.service.IncomeServiceImpl;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/income")
public class IncomeController {

    @Autowired
    IncomeServiceImpl incomeService;
// can use private final incomeservice??
    @PostMapping
    private ResponseEntity<?> saveIncome(@RequestBody IncomeDTO incomeDTO){
        IncomeDTO createdIncome = incomeService.saveIncome(incomeDTO);
        if(createdIncome!=null){
            return ResponseEntity.status(HttpStatus.OK).body(createdIncome);
        }else {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }

    }

    @GetMapping("/{id}")
    private ResponseEntity<?> getIncomebyId(@PathVariable long id){
        try{
            return ResponseEntity.ok(incomeService.getById(id));
        }catch (EntityNotFoundException ex){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(ex.getMessage());
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();

        }
    }

    @GetMapping("/all")
    private ResponseEntity<?> getAllIncome(){

        return ResponseEntity.ok(incomeService.getAllIncome());
    }

    @PutMapping("/{id}")
    private ResponseEntity<?> updateIncome(@PathVariable long id,@RequestBody IncomeDTO incomeDTO){
        try{
            return ResponseEntity.ok(incomeService.updateIncome(id,incomeDTO));
        }catch (EntityNotFoundException ex){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(ex.getMessage());
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();

        }
    }

    @DeleteMapping("/{id}")
    private ResponseEntity<?> deleteIncome(@PathVariable long id){
        try{
            incomeService.deleteIncome(id);
            return ResponseEntity.ok(null);
        }catch (EntityNotFoundException ex){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(ex.getMessage());
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();

        }
    }


}
