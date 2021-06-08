package com.springcar.app.security.config;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.stereotype.Component;
import org.springframework.util.Assert;

import com.springcar.app.models.entity.Role;
import com.springcar.app.models.entity.User;
import com.springcar.app.models.service.UserService;
import com.springcar.app.models.service.UserServiceImpl;


@Component
public class AjaxAuthenticationProvider implements AuthenticationProvider {
	
	@Autowired
    private  BCryptPasswordEncoder encoder;
	@Autowired
    private  UserService userService;
	
	@Autowired
    private  AjaxAwareAuthenticationFailureHandler failureHandler;

    public AjaxAuthenticationProvider(final UserServiceImpl userService, final BCryptPasswordEncoder encoder) {
        this.userService = userService;
        this.encoder = encoder;
    }

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        Assert.notNull(authentication, "No authentication data provided");

        String username = (String) authentication.getPrincipal();
        String password = (String) authentication.getCredentials();
        
        User user = userService.findByEmail(username).orElseThrow(() -> new UsernameNotFoundException("User not found: " + username));
       
        if (!encoder.matches(password, user.getPassword())) {
        	//userService.updateUnsuccessfullAttempt(LOGIN_FAIL,user.getUserId(),user.getEmail());
            throw new BadCredentialsException("Authentication Failed. Username or Password not valid.");
        }else{
        	//userService.updateUnsuccessfullAttempt(LOGIN_SUCCESS,user.getUserId(),user.getEmail());
        }

/*        if (user.getRoles() == null) throw new InsufficientAuthenticationException("User has no roles assigned");
        
        List<GrantedAuthority> authorities = user.getRoles().stream()
                .map(authority -> new SimpleGrantedAuthority(authority.getRole().authority()))
                .collect(Collectors.toList());
*/        
        List<GrantedAuthority> authorities = new ArrayList<>();
        Role optionalRole = userService.getRoleById(user.getId());
        String role = "USER";
        if(optionalRole != null) {
        	 role = optionalRole.getRole();
        }
        authorities.add(new SimpleGrantedAuthority("ROLE_"+role));
        UserContext userContext = UserContext.create(user.getId(), user.getEmail(), authorities);
        
        return new UsernamePasswordAuthenticationToken(userContext, null, userContext.getAuthorities());
    }

    @Override
    public boolean supports(Class<?> authentication) {
        return (UsernamePasswordAuthenticationToken.class.isAssignableFrom(authentication));
    }
    
}