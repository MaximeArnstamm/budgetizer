package fr.bro.budgetizer.controller;

import java.math.BigDecimal;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import fr.bro.budgetizer.valueobject.DashboardVO;

@Controller
public class HomeController {

	@RequestMapping("/")
	public String showHomePage(Model model) {
		BigDecimal budget = new BigDecimal("2913");
		BigDecimal encours = new BigDecimal("3000");
		DashboardVO dashboardVO = new DashboardVO(budget, encours);

		model.addAttribute("dashboard", dashboardVO);

		return "home";
	}
}
