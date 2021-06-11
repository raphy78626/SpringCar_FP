package com.springcar.app.models.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.springcar.app.models.entity.User;
import com.springcar.app.models.entity.UserRole;

public interface UserRoleRepository extends JpaRepository<User, Long> {
	
	@Query("SELECT ur FROM UserRole ur WHERE ur.id=:id")
	public UserRole getUserRoleById(@Param("id") Long id);

}
