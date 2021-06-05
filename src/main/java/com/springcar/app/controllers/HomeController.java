package com.springcar.app.controllers;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class HomeController {

	
	@GetMapping("/")
	public String showHome (HttpSession session, Model model) {		
		return "index";
	}
	
	@PostMapping("/")
	public String setDatesToRent(HttpSession session) {
		
		return "redirect:/reservation/vehicleselect";
	}
	
	
}
