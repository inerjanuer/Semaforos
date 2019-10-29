package com.metodos.formales.home.controller;

import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;


@Controller
public class HomeController {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(HomeController.class);
	
	private static final String RETRIEVE_JSP ="home/home";
	
	
	@GetMapping("/")
	public String retrieve(Model model, RedirectAttributes redirectAttributes, Locale locale) {
		model.addAttribute("user", SecurityContextHolder.getContext().getAuthentication().getName());
		model.addAttribute("rolesAutenticate", SecurityContextHolder.getContext().getAuthentication().getAuthorities());
		return RETRIEVE_JSP;
	}

}
