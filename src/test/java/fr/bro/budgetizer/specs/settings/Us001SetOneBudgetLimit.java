package fr.bro.budgetizer.specs.settings;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import java.util.List;

import org.junit.runner.RunWith;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.ResultActions;

import fr.bro.budgetizer.domain.BudgetLimit;
import fr.bro.budgetizer.specs.SpecTest;
import fr.bro.budgetizer.specs.SpringConcordionJUnitRunner;

@WebAppConfiguration
@RunWith(SpringConcordionJUnitRunner.class)
@ContextConfiguration(locations = { "file:src/main/webapp/WEB-INF/mvc-dispatcher-servlet.xml" })
public class Us001SetOneBudgetLimit extends SpecTest {

	private ResultActions loadSettings() throws Exception {
		return getMockMvc().perform( //
				get("/settings/") //
				);
	}

	private ResultActions saveSettings(String budgetLimit, String expenseCategory) throws Exception {
		return getMockMvc().perform( //
				post("/settings/budget/add") //
						.contentType(MediaType.APPLICATION_FORM_URLENCODED) //
						.param("budgetLimit", budgetLimit) //
						.param("expenseCategory", expenseCategory) //
				);
	}

	// ///////////////////////////////////////////////////////////////////////////////
	// Given
	// ///////////////////////////////////////////////////////////////////////////////

	public boolean addBudgetInDatabase(String budgetLimit, String expenseCategory) {
		BudgetLimit limit = new BudgetLimit();
		limit.setBudgetLimit(budgetLimit);
		limit.setExpenseCategory(expenseCategory);
		getBudgetLimitRepository().save(limit);
		return true;
	}

	// ///////////////////////////////////////////////////////////////////////////////
	// When
	// ///////////////////////////////////////////////////////////////////////////////
	public boolean addBudgetLimit(String budgetLimit, String expenseCategory) throws Exception {
		saveSettings(budgetLimit, expenseCategory) //
				.andExpect(status().is3xxRedirection()) //
				.andExpect(view().name("redirect:/settings"));

		return true;
	}

	// ///////////////////////////////////////////////////////////////////////////////
	// Then
	// ///////////////////////////////////////////////////////////////////////////////

	public List<String> addBudgetWithErrors(String budgetLimit, String expenseCategory) throws Exception {
		MvcResult result = saveSettings(budgetLimit, expenseCategory) //
				.andExpect(view().name("redirect:/settings")) //
				.andReturn();

		return getAllErrorMessagesFromMvcResult("budget", result);
	}

	@SuppressWarnings("unchecked")
	public List<BudgetLimit> printBudgetLimitList() throws Exception {
		MvcResult result = loadSettings() //
				.andExpect(status().isOk()) //
				.andExpect(view().name("settings")) //
				.andReturn();

		return (List<BudgetLimit>) result.getModelAndView().getModel().get("budgets");
	}
}
