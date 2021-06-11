package com.springcar.app.models.dao;

import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.springcar.app.models.entity.User;


public interface IUserDao extends CrudRepository<User, Long> {
	
	@Query("select u from User u where u.email = ?1")
	public Optional<User> findByEmail(String email);

}
