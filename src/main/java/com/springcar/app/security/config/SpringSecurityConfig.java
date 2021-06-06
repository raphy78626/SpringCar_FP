package com.springcar.app.security.config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.access.AccessDeniedHandler;

/**
 * Spring Security Configuration
 * http://docs.spring.io/spring-boot/docs/current/reference/html/howto-security.html
 * Switches off Spring Boot automatic security configuration
 *
 * @author Dusan
 */
@Configuration
@EnableWebSecurity
public class SpringSecurityConfig extends WebSecurityConfigurerAdapter {

    private final AccessDeniedHandler accessDeniedHandler;

    final DataSource dataSource;

    @Value("${spring.admin.username}")
    private String adminUsername;

    @Value("${spring.admin.username}")
    private String adminPassword;

    @Value("${spring.queries.users-query}")
    private String usersQuery;

    @Value("${spring.queries.roles-query}")
    private String rolesQuery;
    
    @Autowired
	CustomUserDetailsService userDetailsService;

    @Autowired
    public SpringSecurityConfig(AccessDeniedHandler accessDeniedHandler, DataSource dataSource) {
        this.accessDeniedHandler = accessDeniedHandler;
        this.dataSource = dataSource;
    }
    
    @Override
    public void configure(WebSecurity web) throws Exception {
      web
        .ignoring()
           .antMatchers("/resources/**"
        		   ,"/assets/**", 
        		   "/static/**", 
        		   "/static/assets/**", 
        		   "/css/**", 
        		   "/js/**", 
        		   "/img/**", 
        		   "/icon/**", 
        		   "/vendor/**"); // #3
    }

    /**
     * HTTPSecurity configurer
     * - roles ADMIN allow to access /admin/**
     * - roles USER allow to access /user/** and /newPost/**
     * - anybody can visit /, /home, /about, /registration, /error, /blog/**, /post/**, /h2-console/**
     * - every other page needs authentication
     * - custom 403 access denied handler
     */
    @Override
    protected void configure(HttpSecurity http) throws Exception {
    	 http.authorizeRequests().antMatchers("/assets/images/**","/vendor/**","/images/**", "/js/**",  "/css/**",  
    			 "/assets/images/**", "/assets/css/**", 
    			 "/assets/fonts/**", "/assets/js/**").permitAll().anyRequest().permitAll();
        http.csrf().disable()
                .authorizeRequests()
                .antMatchers("/fleet/index", "/user/login/", "/user/registration", "/error", "/h2-console/**").permitAll()
                .anyRequest().authenticated()
                .and()
                .formLogin()
                .loginPage("/user/login")
                .usernameParameter("email")
                .defaultSuccessUrl("/fleet")
                .permitAll()
                .and()
                .logout()
                .permitAll()
                .and()
                .exceptionHandling().accessDeniedHandler(accessDeniedHandler)
                // Fix for H2 console
                .and().headers().frameOptions().disable();
    }


    @Bean
	public DaoAuthenticationProvider authProvider() {
		DaoAuthenticationProvider authProvider = new DaoAuthenticationProvider();
		authProvider.setUserDetailsService(userDetailsService);
		authProvider.setPasswordEncoder(passwordEncoder());
		return authProvider;
	}
    
    /**
     * Authentication details
     */
	/*
	 * @Autowired public void configureGlobal(AuthenticationManagerBuilder auth)
	 * throws Exception {
	 * 
	 * // Database authentication auth. jdbcAuthentication()
	 * .usersByUsernameQuery(usersQuery) .authoritiesByUsernameQuery(rolesQuery)
	 * .dataSource(dataSource) .passwordEncoder(passwordEncoder());
	 * 
	 * // In memory authentication auth.inMemoryAuthentication()
	 * .withUser(adminUsername).password(adminPassword).roles("ADMIN"); }
	 */

    /**
     * Configure and return BCrypt password encoder
     */
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

}
