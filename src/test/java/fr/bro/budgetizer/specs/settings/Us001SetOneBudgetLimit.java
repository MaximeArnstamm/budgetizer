package fr.bro.budgetizer.specs.settings;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import java.util.List;

import org.junit.runner.RunWith;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.web.WebAppConfiguration;

import fr.bro.budgetizer.domain.BudgetLimit;
import fr.bro.budgetizer.specs.SpecTest;
import fr.bro.budgetizer.specs.SpringConcordionJUnitRunner;

@WebAppConfiguration
@RunWith(SpringConcordionJUnitRunner.class)
@ContextConfiguration(locations = { "file:src/main/webapp/WEB-INF/spring-config.xml" })
public class Us001SetOneBudgetLimit extends SpecTest {

	public Long nbBudgetLimits() {
		return getBudgetLimitRepository().count();
	}

	public boolean addBudgetLimit(String budgetLimit, String expenseCategory) throws Exception {
		getMockMvc().perform( //
				post("/settings/budget/add") //
						.contentType(MediaType.APPLICATION_FORM_URLENCODED) //
						.param("budgetLimit", budgetLimit) //
						.param("expenseCategory", expenseCategory) //
				) //
				.andExpect(status().isOk()) //
				.andExpect(view().name("settings")); //

		return true;
	}

	public List<BudgetLimit> fetchBudgetLimitList() {
		return getBudgetLimitRepository().findAll();
	}

}
