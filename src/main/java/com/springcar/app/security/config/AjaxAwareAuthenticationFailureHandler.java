package com.springcar.app.security.config;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.databind.ObjectMapper;

@Component
public class AjaxAwareAuthenticationFailureHandler implements AuthenticationFailureHandler {
    
	@Override
	public void onAuthenticationFailure(HttpServletRequest request, HttpServletResponse response,
			AuthenticationException e) throws IOException, ServletException {
		
		response.setStatus(HttpStatus.UNAUTHORIZED.value());
		response.setContentType(MediaType.APPLICATION_JSON_VALUE);
		
		if (e instanceof BadCredentialsException) {
			request.getSession().setAttribute("error_userAuthentification", "Username or password is wrong!");
			response.sendRedirect("/user/login");
		} /*
			 * else if (e instanceof JwtExpiredTokenException) {
			 * mapper.writeValue(response.getWriter(), ErrorResponse.of("Token has expired",
			 * ErrorCode.JWT_TOKEN_EXPIRED, HttpStatus.UNAUTHORIZED)); } else if (e
			 * instanceof AuthMethodNotSupportedException) {
			 * mapper.writeValue(response.getWriter(), ErrorResponse.of(e.getMessage(),
			 * ErrorCode.AUTHENTICATION, HttpStatus.UNAUTHORIZED)); } else if (e instanceof
			 * UnverifiedUserException) { mapper.writeValue(response.getWriter(),
			 * ErrorResponse.of(e.getMessage(), ErrorCode.AUTHENTICATION,
			 * HttpStatus.FORBIDDEN)); }else{ mapper.writeValue(response.getWriter(),
			 * ErrorResponse.of("Authentication failed", ErrorCode.AUTHENTICATION,
			 * HttpStatus.UNAUTHORIZED)); }
			 */
	}
}