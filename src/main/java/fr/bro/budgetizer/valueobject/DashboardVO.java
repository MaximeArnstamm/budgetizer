package fr.bro.budgetizer.valueobject;

import java.io.Serializable;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.DecimalFormat;

public class DashboardVO implements Serializable {
	private static final long serialVersionUID = 1L;

	protected static final String STATE_GOOD = "panel-green";
	protected static final String MSG_GOOD = "Tout va bien !";
	protected static final String STATE_LIMIT = "panel-yellow";
	protected static final String MSG_LIMIT = "C'est limite limite ...";
	protected static final String STATE_BAD = "panel-red";
	protected static final String MSG_BAD = "On est dans le caca !";

	protected static final BigDecimal seuil = new BigDecimal("70");
	protected static final BigDecimal cent = new BigDecimal("100");

	private String state;
	private String globalLevel;
	private String message;

	public DashboardVO(BigDecimal budget, BigDecimal encours) {
		BigDecimal perc = encours.divide(budget, 2, RoundingMode.HALF_UP).multiply(cent);

		computeStates(cent, perc);
		globalLevel = format(perc);
	}

	private void computeStates(BigDecimal cent, BigDecimal perc) {
		if (perc.compareTo(seuil) < 0) {
			setGood();
		} else if (perc.compareTo(cent) < 0) {
			setLimit();
		} else {
			setBad();
		}
	}

	private void setBad() {
		state = STATE_BAD;
		message = MSG_BAD;
	}

	private void setLimit() {
		state = STATE_LIMIT;
		message = MSG_LIMIT;
	}

	private void setGood() {
		state = STATE_GOOD;
		message = MSG_GOOD;
	}

	private String format(BigDecimal perc) {
		DecimalFormat df = new DecimalFormat();
		df.setMaximumFractionDigits(0);
		df.setGroupingUsed(false);
		return df.format(perc);
	}

	public String getState() {
		return state;
	}

	public String getGlobalLevel() {
		return globalLevel;
	}

	public String getMessage() {
		return message;
	}
}
