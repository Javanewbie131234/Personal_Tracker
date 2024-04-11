package com.PersonalTracker.Personal.dto;

import java.time.LocalDate;

public record IncomeDTO(Long id, String title, Integer amount, String category, String description, LocalDate date) {
}
