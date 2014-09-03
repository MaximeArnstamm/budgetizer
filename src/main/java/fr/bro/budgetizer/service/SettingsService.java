package fr.bro.budgetizer.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.bro.budgetizer.domain.Settings;
import fr.bro.budgetizer.repository.BudgetLimitRepository;

@Service
public class SettingsService {
	@Autowired
	protected BudgetLimitRepository budgetLimitRepository;

	public Settings fetchSettings() {
		Settings settings = new Settings();

		return settings;
	}
}
