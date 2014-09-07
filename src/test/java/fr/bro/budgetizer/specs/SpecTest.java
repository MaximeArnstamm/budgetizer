package fr.bro.budgetizer.specs;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.validation.Errors;
import org.springframework.validation.ObjectError;
import org.springframework.web.context.WebApplicationContext;

import fr.bro.budgetizer.repository.BudgetLimitRepository;
import fr.bro.budgetizer.service.SettingsService;

public class SpecTest {
	@Autowired
	private BudgetLimitRepository budgetLimitRepository;
	@Autowired
	private SettingsService settingsService;
	@Autowired
	private WebApplicationContext webApplicationContext;

	public boolean resetDatabase() {
		budgetLimitRepository.deleteAll();

		return true;
	}

	protected List<String> getAllErrorMessagesFromMvcResult(String key, MvcResult mvcResult) {
		Errors errors = (Errors) mvcResult.getFlashMap().get("org.springframework.validation.BindingResult." + key);
		List<ObjectError> list = errors.getAllErrors();
		List<String> res = new ArrayList<String>();
		for (ObjectError oe : list) {
			res.add(oe.getDefaultMessage());
		}
		Collections.sort(res);
		return res;
	}

	protected BudgetLimitRepository getBudgetLimitRepository() {
		return budgetLimitRepository;
	}

	protected SettingsService getSettingsService() {
		return settingsService;
	}

	protected MockMvc getMockMvc() {
		return MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
	}
}
