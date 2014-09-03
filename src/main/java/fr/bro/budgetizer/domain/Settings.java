package fr.bro.budgetizer.domain;

import java.io.Serializable;

import javax.validation.constraints.Digits;
import javax.validation.constraints.NotNull;

public class Settings implements Serializable {
	private static final long serialVersionUID = 1L;

	@NotNull(message = "Le budget est obligatoire")
	@Digits(integer = 10, fraction = 2, message = "Budget doit être un montant")
	private String budget;

	public String getBudget() {
		return budget;
	}

	public void setBudget(String budget) {
		this.budget = budget;
	}
}
