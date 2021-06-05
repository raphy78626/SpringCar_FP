package com.springcar.app;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.springcar.app.controllers.beans.LoginBean;


@Configuration
public class AppConfig {
	
	@Bean
	public LoginBean myBean() {
		return new LoginBean();
	}
	
}
