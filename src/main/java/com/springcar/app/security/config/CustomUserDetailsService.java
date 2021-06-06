package com.springcar.app.security.config;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.springcar.app.models.entity.Role;
import com.springcar.app.models.entity.User;
import com.springcar.app.models.service.UserService;

@Service("customUserDetailsService")
public class CustomUserDetailsService implements UserDetailsService {

	@Autowired
	private UserService userService;

	@Transactional
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Optional<User> optionalUser = userService.findByEmail(username);

		if (optionalUser.isPresent()) {
			User user = optionalUser.get();
			List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
			Collection<Role> userRoles = user.getRoles();
			authorities.add(new SimpleGrantedAuthority("ROLE_ADMIN"));

			return new org.springframework.security.core.userdetails.User(user.getEmail(), user.getPassword(),
					authorities);
		}
		throw new UsernameNotFoundException("Username not found");
	}

}
