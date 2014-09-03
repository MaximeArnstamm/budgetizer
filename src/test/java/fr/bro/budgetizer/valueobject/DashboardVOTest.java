package fr.bro.budgetizer.valueobject;

import java.math.BigDecimal;

import org.junit.Assert;
import org.junit.Test;

public class DashboardVOTest {

	@Test
	public void DashboardVO_state_should_be_good() {
		// Given
		BigDecimal budget = new BigDecimal("100");
		BigDecimal encours = new BigDecimal("50");

		// When
		DashboardVO actual = new DashboardVO(budget, encours);

		// Then
		Assert.assertEquals(DashboardVO.STATE_GOOD, actual.getState());
	}

	@Test
	public void DashboardVO_state_should_be_limit() {
		// Given
		BigDecimal budget = new BigDecimal("100");
		BigDecimal encours = new BigDecimal("80");

		// When
		DashboardVO actual = new DashboardVO(budget, encours);

		// Then
		Assert.assertEquals(DashboardVO.STATE_LIMIT, actual.getState());
	}

	@Test
	public void DashboardVO_state_should_be_bad() {
		// Given
		BigDecimal budget = new BigDecimal("100");
		BigDecimal encours = new BigDecimal("100");

		// When
		DashboardVO actual = new DashboardVO(budget, encours);

		// Then
		Assert.assertEquals(DashboardVO.STATE_BAD, actual.getState());
	}

	@Test
	public void DashboardVO_level_should_have_no_decimals() {
		// Given
		BigDecimal budget = new BigDecimal("7");
		BigDecimal encours = new BigDecimal("5");

		// When
		DashboardVO actual = new DashboardVO(budget, encours);

		// Then
		Assert.assertEquals("71", actual.getGlobalLevel());
	}

	@Test
	public void DashboardVO_message_should_be_good() {
		// Given
		BigDecimal budget = new BigDecimal("100");
		BigDecimal encours = new BigDecimal("50");

		// When
		DashboardVO actual = new DashboardVO(budget, encours);

		// Then
		Assert.assertEquals(DashboardVO.MSG_GOOD, actual.getMessage());
	}

	@Test
	public void DashboardVO_message_should_be_limit() {
		// Given
		BigDecimal budget = new BigDecimal("100");
		BigDecimal encours = new BigDecimal("80");

		// When
		DashboardVO actual = new DashboardVO(budget, encours);

		// Then
		Assert.assertEquals(DashboardVO.MSG_LIMIT, actual.getMessage());
	}

	@Test
	public void DashboardVO_message_should_be_bad() {
		// Given
		BigDecimal budget = new BigDecimal("100");
		BigDecimal encours = new BigDecimal("100");

		// When
		DashboardVO actual = new DashboardVO(budget, encours);

		// Then
		Assert.assertEquals(DashboardVO.MSG_BAD, actual.getMessage());
	}
}
