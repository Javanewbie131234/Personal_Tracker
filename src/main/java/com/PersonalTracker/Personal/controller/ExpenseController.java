package com.PersonalTracker.Personal.controller;

import com.PersonalTracker.Personal.dto.ExpenseDTO;
import com.PersonalTracker.Personal.service.ExpenseService;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/expense")
public class ExpenseController {

    @Autowired
    ExpenseService expenseService;

    @PostMapping
    public ResponseEntity<?> saveExpense(@RequestBody ExpenseDTO expenseDTO) {
        ExpenseDTO createExpense = expenseService.saveExpense(expenseDTO);
        if(createExpense!=null){
            return ResponseEntity.status(HttpStatus.CREATED).body(createExpense);
        }else{
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    }

    @GetMapping("/all")
    public ResponseEntity<?> getAllExpenses(){
//        return ResponseEntity.status(HttpStatus.OK).body(expenseService.getAllExpenses());
        return ResponseEntity.ok(expenseService.getAllExpenses());
    }
    @GetMapping("/{id}")
    public ResponseEntity<?> getExpensebyId(@PathVariable Long id){
        try{
            return ResponseEntity.ok(expenseService.getExpensebyId(id));
        }catch (EntityNotFoundException ex){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(ex.getMessage());

        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Something went wrong");
        }

    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateExpense(@PathVariable long id,@RequestBody ExpenseDTO expenseDTO){
        try {
            return ResponseEntity.ok(expenseService.updateExpense(id,expenseDTO));
        }catch (EntityNotFoundException ex){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(ex.getMessage());
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Something went wrong");

        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteExpense(@PathVariable long id){
        try {
            expenseService.deleteExpense(id);
            return ResponseEntity.ok(null);
        } catch (EntityNotFoundException ex){
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body(ex.getMessage());
        } catch (Exception e) {
                return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Something went wrong");

        }

    }




}
