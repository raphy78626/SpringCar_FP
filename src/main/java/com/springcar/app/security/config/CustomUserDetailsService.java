package com.springcar.app.security.config;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.springcar.app.models.entity.User;
import com.springcar.app.models.entity.UserRole;
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
			Set<UserRole> userRoles = user.getUserRolesList();
			for (UserRole ur : userRoles) {
				authorities.add(new SimpleGrantedAuthority("ROLE_" + ur.getType()));
			}

			return new org.springframework.security.core.userdetails.User(user.getEmail(), user.getPassword(),
					authorities);
		}
		throw new UsernameNotFoundException("Username not found");
	}

}
