package com.springcar.app.models.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.springcar.app.models.dao.IUserDao;
import com.springcar.app.models.dao.UserRepository;
import com.springcar.app.models.entity.User;

@Service
public class UserServiceImpl implements UserService {

	
	@Autowired
    private  UserRepository userRepository;
	
	@Autowired
    private  PasswordEncoder passwordEncoder;
	
	@Autowired
	private IUserDao userDao;

    private static final String USER_ROLE = "USER";

   


    @Override
    public Optional<User> findByEmail(String email) {
        return userDao.findByEmail(email);
    }
    
  
    @Override
    public User saveUser(User user) {
        // Encode plaintext password
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        user.setActive(1);
        return userRepository.addUser(user);
    }
}
