package fr.bro.budgetizer.repository;

import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import fr.bro.budgetizer.domain.BudgetLimit;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "file:src/main/webapp/WEB-INF/mvc-dispatcher-servlet.xml" })
public class BudgetLimitRepositoryTest {

	@Autowired
	private BudgetLimitRepository budgetLimitRepository;

	@Test
	@Rollback(value = true)
	public void findAllOrderByExpenseCategory() {
		// Given
		BudgetLimit budgetLimit1 = new BudgetLimit();
		budgetLimit1.setBudgetLimit("1000");
		budgetLimit1.setExpenseCategory("Shopping");
		budgetLimitRepository.save(budgetLimit1);

		BudgetLimit budgetLimit2 = new BudgetLimit();
		budgetLimit2.setBudgetLimit("400");
		budgetLimit2.setExpenseCategory("Food");
		budgetLimitRepository.save(budgetLimit2);

		budgetLimitRepository.flush();

		// When
		List<BudgetLimit> actual = budgetLimitRepository.findAll(new Sort(Direction.ASC, "expenseCategory"));

		// Then
		Assert.assertEquals(2, actual.size());
		Assert.assertEquals(budgetLimit2, actual.get(0));
		Assert.assertEquals(budgetLimit1, actual.get(1));
	}

}
