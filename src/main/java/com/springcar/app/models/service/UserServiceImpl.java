package com.springcar.app.models.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.springcar.app.models.dao.RoleRepository;
import com.springcar.app.models.dao.UserRepository;
import com.springcar.app.models.entity.Role;
import com.springcar.app.models.entity.User;

@Service
public class UserServiceImpl implements UserService {

	
	@Autowired
    private  UserRepository userRepository;
	@Autowired
    private  RoleRepository roleRepository;
	@Autowired
    private  PasswordEncoder passwordEncoder;

    private static final String USER_ROLE = "USER";

   


    @Override
    public Optional<User> findByEmail(String email) {
        return userRepository.findByEmail(email);
    }
    
    @Override
    public Role getRoleById(Long roleId) {
        return roleRepository.findByRoleId(roleId);
    }

    @Override
    public User saveUser(User user) {
        // Encode plaintext password
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        user.setActive(1);
        // Set Role to ROLE_USER
        Role role = new Role();
        role.setRole(USER_ROLE);
        user.setRole(role);
        return userRepository.saveAndFlush(user);
    }
}
