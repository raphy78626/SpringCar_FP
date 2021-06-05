package com.springcar.app.controllers;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;



@Controller
public class DateSelectionController {

	

	
	@GetMapping("/reservation/dateselection")
	public String showDateSelection (Model model, HttpSession session) {
	
		return "/reservation/dateselection/index";
		
	}
	
	@PostMapping("/reservation/dateselection")
	public String setDateSelection( HttpSession session) {
		
		
			return "redirect:/reservation/dateselection/"; 
	}
	
	
	
}
