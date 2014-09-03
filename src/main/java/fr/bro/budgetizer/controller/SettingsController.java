package fr.bro.budgetizer.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import fr.bro.budgetizer.domain.BudgetLimit;
import fr.bro.budgetizer.repository.BudgetLimitRepository;
import fr.bro.budgetizer.service.SettingsService;

@Controller
@RequestMapping("/settings")
public class SettingsController {
	@Autowired
	protected SettingsService settingsService;

	@Autowired
	protected BudgetLimitRepository budgetLimitRepository;

	@RequestMapping(method = RequestMethod.GET)
	public void loadSettings(Model model) {
		// get full settings
	}

	@RequestMapping(value = "/budget/add", method = RequestMethod.POST)
	public String saveSettings(@ModelAttribute("budget") @Valid BudgetLimit budgetLimit, Errors errors) {
		budgetLimitRepository.save(budgetLimit);

		return "settings";
	}
}
