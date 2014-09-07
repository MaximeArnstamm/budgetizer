package fr.bro.budgetizer.controller;

import static org.mockito.Matchers.any;
import static org.mockito.Mockito.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Sort;
import org.springframework.ui.ExtendedModelMap;
import org.springframework.ui.Model;
import org.springframework.validation.BeanPropertyBindingResult;
import org.springframework.validation.Errors;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.mvc.support.RedirectAttributesModelMap;

import fr.bro.budgetizer.domain.BudgetLimit;
import fr.bro.budgetizer.repository.BudgetLimitRepository;

@RunWith(MockitoJUnitRunner.class)
public class SettingsControllerTest {
	@Mock
	private BudgetLimitRepository budgetLimitRepository;

	@InjectMocks
	private SettingsController settingsController;

	@Test
	public void saveSettings_should_save() {
		// Given
		BudgetLimit budgetLimit = new BudgetLimit();
		budgetLimit.setBudgetLimit("400");
		budgetLimit.setExpenseCategory("Food");

		Errors errors = new BeanPropertyBindingResult(budgetLimit, "budget");

		RedirectAttributes redirectAttributes = new RedirectAttributesModelMap();

		// When
		settingsController.saveSettings(budgetLimit, errors, redirectAttributes);

		// Then
		verify(budgetLimitRepository).save(budgetLimit);
	}

	@Test
	public void saveSettings_should_not_save_if_errors() {
		// Given
		BudgetLimit budgetLimit = new BudgetLimit();

		Errors errors = new BeanPropertyBindingResult(budgetLimit, "budget");
		errors.reject("");

		RedirectAttributes redirectAttributes = new RedirectAttributesModelMap();

		// When
		settingsController.saveSettings(budgetLimit, errors, redirectAttributes);

		// Then
		verify(budgetLimitRepository, never()).save(budgetLimit);
	}

	@Test
	public void saveSettings_should_reject_if_category_is_not_unique() {
		// Given
		BudgetLimit budgetLimit = new BudgetLimit();

		Errors errors = new BeanPropertyBindingResult(budgetLimit, "budget");

		when(budgetLimitRepository.save(budgetLimit)).thenThrow(new DataIntegrityViolationException(""));

		RedirectAttributes redirectAttributes = new RedirectAttributesModelMap();

		// When
		settingsController.saveSettings(budgetLimit, errors, redirectAttributes);

		// Then
		Assert.assertEquals(1, errors.getAllErrors().size());
		Assert.assertEquals(SettingsController.MSG_ERROR_NON_UNIQUE_CATEGORY, errors.getAllErrors().get(0).getDefaultMessage());
	}

	@Test
	public void loadSettings() {
		// Given
		BudgetLimit budgetLimit1 = new BudgetLimit();
		BudgetLimit budgetLimit2 = new BudgetLimit();
		List<BudgetLimit> budgets = Arrays.asList(budgetLimit1, budgetLimit2);

		when(budgetLimitRepository.findAll(any(Sort.class))).thenReturn(budgets);

		Model model = new ExtendedModelMap();

		// When
		settingsController.loadSettings(model);

		// Then
		Assert.assertNotNull(model.asMap().get("budget"));
		Assert.assertEquals(budgets, model.asMap().get("budgets"));
	}

	@Test
	public void loadSettings_should_keep_redirect_values() {
		// Given
		BudgetLimit budgetLimit = new BudgetLimit();
		budgetLimit.setBudgetLimit("400");

		when(budgetLimitRepository.findAll(any(Sort.class))).thenReturn(new ArrayList<BudgetLimit>());

		Model model = new ExtendedModelMap();
		model.addAttribute("budget", budgetLimit);

		// When
		settingsController.loadSettings(model);

		// Then
		Assert.assertSame(budgetLimit, model.asMap().get("budget"));
	}


}
