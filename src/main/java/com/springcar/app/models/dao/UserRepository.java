package com.springcar.app.models.dao;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;

import com.springcar.app.models.entity.User;
import com.springcar.app.repository.UserRepositoryCustom;

public interface UserRepository extends PagingAndSortingRepository<User, Long>, UserRepositoryCustom {

	@Query("SELECT u FROM User u LEFT JOIN FETCH u.userRolesList")
	public List<User> getAllUser();

	@Query("SELECT u FROM User u LEFT JOIN FETCH u.userRolesList WHERE u.id=:id")
	public User getUserById(@Param("id") Long id);


	@Query(value = "SELECT DISTINCT u FROM User u LEFT JOIN FETCH u.userRolesList", countQuery = "SELECT COUNT(u) FROM User u")
	public Page<User> getUserForPage(Pageable pageable);

}