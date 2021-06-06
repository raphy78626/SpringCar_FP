package com.springcar.app.models.service;

import java.util.Collections;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.springcar.app.models.dao.RoleRepository;
import com.springcar.app.models.dao.UserRepository;
import com.springcar.app.models.entity.User;

@Service
public class UserServiceImp implements UserService {

	
	@Autowired
    private  UserRepository userRepository;
	@Autowired
    private  RoleRepository roleRepository;
	@Autowired
    private  PasswordEncoder passwordEncoder;

    private static final String USER_ROLE = "ROLE_USER";

   

    @Override
    public Optional<User> findByUserName(String username) {
        return userRepository.findByUserName(username);
    }

    @Override
    public Optional<User> findByEmail(String email) {
        return userRepository.findByEmail(email);
    }

    @Override
    public User saveUser(User user) {
        // Encode plaintext password
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        user.setActive(1);
        // Set Role to ROLE_USER
        user.setRoles(Collections.singletonList(roleRepository.findByRole(USER_ROLE)));
        return userRepository.saveAndFlush(user);
    }
}
