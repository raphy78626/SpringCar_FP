package com.springcar.app.models.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

import com.springcar.app.models.entity.Role;

public interface RoleRepository extends JpaRepository<Role, Long> {
    Role findByRole(@Param("role") String role);
    
    Role findByRoleId(@Param("roleId") Long roleId);
}
