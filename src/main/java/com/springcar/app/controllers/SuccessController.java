package com.springcar.app.controllers;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class SuccessController {

	
	@GetMapping("/reservation/success")
	public String showSuccessPage(HttpSession session) {

		return "reservation/success/index";
	}
	
}
