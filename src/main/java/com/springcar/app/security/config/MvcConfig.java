package com.springcar.app.security.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
@EnableWebMvc
public class MvcConfig implements WebMvcConfigurer {
	
	public MvcConfig()
	{
		super();
	}
	@Override
    public void addViewControllers(ViewControllerRegistry registry) {
		 registry.addViewController("/user/register/index.html");
		 registry.addViewController("/user/login/index.html");
		 registry.addViewController("about-us.html");
		 registry.addViewController("contact.html");
	      
    	
	}
	@Override
	public void addResourceHandlers(final ResourceHandlerRegistry registry)
	{
		registry.addResourceHandler("/**",
				"/assets/**",
        		"/css/**",
        		"/vendor/**",
                "/resources/**",
                "/js/**",
                "/images/**",
                "/api/**",
                "/font-awesome/**"
                
               )
		        .addResourceLocations(
		           "classpath:/static/vendor/",
        		   "classpath:/static/css/",
        		   "classpath:/static/js/",
        		   "classpath:/static/images/",
        		   "classpath:/static/api/",
                   "classpath:/resources/",
                   "classpath:/static/font-awesome/",
                   "classpath:/static/assets/",
                   "classpath:/static/assets/images/", 
                   "classpath:/static/assets/css/", 
                   "classpath:/static/assets/fonts/");
	}
}