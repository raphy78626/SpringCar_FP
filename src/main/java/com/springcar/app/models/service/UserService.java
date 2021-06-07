package com.springcar.app.models.service;

import java.util.Optional;

import com.springcar.app.models.entity.Role;
import com.springcar.app.models.entity.User;

public interface UserService {


    Optional<User> findByEmail(String email);

    User saveUser(User user);
    
    Role getRoleById(Long roleId);

}
