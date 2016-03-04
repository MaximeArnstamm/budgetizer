package fr.bro.budgetizer.controller;

import static org.mockito.Matchers.any;
import static org.mockito.Matchers.eq;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Sort;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import fr.bro.budgetizer.domain.BudgetLimit;
import fr.bro.budgetizer.repository.BudgetLimitRepository;

@RunWith(MockitoJUnitRunner.class)
public class SettingsControllerTest {
	@Mock
	private BudgetLimitRepository budgetLimitRepository;

	@InjectMocks
	private SettingsController settingsController;

	@Mock
	private RedirectAttributes redirectAttributes;

	@Mock
	private Errors errors;

	@Mock
	private Model model;

	@Test
	public void saveSettings_should_save() {
		// Given
		BudgetLimit budgetLimit = new BudgetLimit();
		budgetLimit.setBudgetLimit("400");
		budgetLimit.setExpenseCategory("Food");

		when(errors.hasErrors()).thenReturn(false);

		// When
		settingsController.saveSettings(budgetLimit, errors, redirectAttributes);

		// Then
		verify(budgetLimitRepository).save(budgetLimit);
	}

	@Test
	public void saveSettings_should_redirect() {
		// Given
		BudgetLimit budgetLimit = new BudgetLimit();

		// When
		settingsController.saveSettings(budgetLimit, errors, redirectAttributes);

		// Then
		verify(redirectAttributes).addFlashAttribute("budget", budgetLimit);
		verify(redirectAttributes).addFlashAttribute(SettingsController.BINDING_FIELD + "budget", errors);
	}

	@Test
	public void saveSettings_should_not_save_if_errors() {
		// Given
		BudgetLimit budgetLimit = new BudgetLimit();

		when(errors.hasErrors()).thenReturn(true);

		// When
		settingsController.saveSettings(budgetLimit, errors, redirectAttributes);

		// Then
		verify(budgetLimitRepository, never()).save(budgetLimit);
	}

	@Test
	public void saveSettings_should_reject_if_category_is_not_unique() {
		// Given
		BudgetLimit budgetLimit = new BudgetLimit();

		when(errors.hasErrors()).thenReturn(false);
		when(budgetLimitRepository.save(budgetLimit)).thenThrow(new DataIntegrityViolationException(""));

		// When
		settingsController.saveSettings(budgetLimit, errors, redirectAttributes);

		// Then
		verify(errors).rejectValue("expenseCategory", "", SettingsController.MSG_ERROR_NON_UNIQUE_CATEGORY);
	}

	@Test
	public void loadSettings() {
		// Given
		BudgetLimit budgetLimit1 = new BudgetLimit();
		BudgetLimit budgetLimit2 = new BudgetLimit();
		List<BudgetLimit> budgets = Arrays.asList(budgetLimit1, budgetLimit2);

		when(budgetLimitRepository.findAll(any(Sort.class))).thenReturn(budgets);

		// When
		settingsController.loadSettings(model);

		// Then
		verify(model).addAttribute("budget", new BudgetLimit());
		verify(model).addAttribute("budgets", budgets);
	}

	@Test
	public void loadSettings_should_keep_existing_values() {
		// Given
		when(model.containsAttribute("budget")).thenReturn(true);

		// When
		settingsController.loadSettings(model);

		// Then
		verify(model, never()).addAttribute(eq("budget"), any());
	}

}
