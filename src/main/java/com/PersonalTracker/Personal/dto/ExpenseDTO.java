package com.PersonalTracker.Personal.dto;

import java.time.LocalDate;

public record ExpenseDTO (Long id, String title, String description, String category, LocalDate date, Integer amount) {
}
