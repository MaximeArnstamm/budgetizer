package fr.bro.budgetizer.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import fr.bro.budgetizer.domain.BudgetLimit;
import fr.bro.budgetizer.repository.BudgetLimitRepository;
import fr.bro.budgetizer.service.SettingsService;

@Controller
@RequestMapping("/settings")
public class SettingsController {

	protected static final String MSG_ERROR_NON_UNIQUE_CATEGORY = "La catégorie existe déjà";

	protected static final String BINDING_FIELD = "org.springframework.validation.BindingResult.";

	@Autowired
	protected SettingsService settingsService;

	@Autowired
	protected BudgetLimitRepository budgetLimitRepository;

	@RequestMapping(method = RequestMethod.GET)
	public void loadSettings(Model model) {
		if (!model.containsAttribute("budget")) {
			model.addAttribute("budget", new BudgetLimit());
		}
		model.addAttribute("budgets", budgetLimitRepository.findAll(new Sort(Direction.ASC, "expenseCategory")));
	}

	@RequestMapping(value = "/budget/add", method = RequestMethod.POST)
	public String saveSettings(@ModelAttribute("budget") @Valid BudgetLimit budgetLimit, Errors errors,
			RedirectAttributes redirectAttributes) {
		if (!errors.hasErrors()) {
			try {
				budgetLimitRepository.save(budgetLimit);
			} catch (DataIntegrityViolationException e) {
				errors.rejectValue("expenseCategory", "", MSG_ERROR_NON_UNIQUE_CATEGORY);
			}
		}

		redirectAttributes.addFlashAttribute("budget", budgetLimit);
		redirectAttributes.addFlashAttribute(BINDING_FIELD+"budget", errors);
		return "redirect:/settings";
	}
}
