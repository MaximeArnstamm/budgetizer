package fr.bro.budgetizer.specs;

import org.concordion.api.extension.Extensions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import fr.bro.budgetizer.repository.BudgetLimitRepository;
import fr.bro.budgetizer.service.SettingsService;
import fr.bro.budgetizer.specs.extension.JsExtension;

@Extensions({ JsExtension.class })
public class SpecTest {
	@Autowired
	private BudgetLimitRepository budgetLimitRepository;
	@Autowired
	private SettingsService settingsService;

	@Autowired
	private WebApplicationContext webApplicationContext;

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
