package fr.bro.budgetizer.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import fr.bro.budgetizer.domain.BudgetLimit;

public interface BudgetLimitRepository extends JpaRepository<BudgetLimit, Long> {

}
