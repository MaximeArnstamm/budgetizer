package fr.bro.budgetizer.controller;

import static org.mockito.Mockito.verify;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.validation.BeanPropertyBindingResult;
import org.springframework.validation.Errors;

import fr.bro.budgetizer.domain.BudgetLimit;
import fr.bro.budgetizer.repository.BudgetLimitRepository;

@RunWith(MockitoJUnitRunner.class)
public class SettingsControllerTest {
	@Mock
	private BudgetLimitRepository budgetLimitRepository;

	@InjectMocks
	private SettingsController settingsController;

	@Test
	public void saveSettings() {
		// Given
		BudgetLimit budgetLimit = new BudgetLimit();
		budgetLimit.setBudgetLimit("400");
		budgetLimit.setExpenseCategory("Food");

		Errors errors = new BeanPropertyBindingResult(budgetLimit, "budget");

		// When
		settingsController.saveSettings(budgetLimit, errors);

		// Then
		verify(budgetLimitRepository).save(budgetLimit);
	}

}
