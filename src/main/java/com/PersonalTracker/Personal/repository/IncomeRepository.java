package com.PersonalTracker.Personal.repository;

import com.PersonalTracker.Personal.entity.Income;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IncomeRepository extends JpaRepository<Income, Long> {
}
