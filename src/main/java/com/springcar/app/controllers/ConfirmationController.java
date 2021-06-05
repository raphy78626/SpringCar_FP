package com.springcar.app.controllers;


import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class ConfirmationController {

	
	@GetMapping("/reservation/confirmation")
	public String showConfirmation (Model model, HttpSession session) {
		
		return "/reservation/confirmation/index";
	}
	
	@PostMapping("/reservation/confirmation")
	public String processConfirmation(HttpSession session) {
		
		return "redirect:/reservation/success";
	}
	
}
