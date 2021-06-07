package com.springcar.app.models.entity;

import javax.persistence.*;
import java.util.Collection;

@Entity
@Table(name = "role")
public class Role {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "role_id")
    private Long roleId;

    public Long getRoleId() {
		return roleId;
	}

	public void setRoleId(Long roleId) {
		this.roleId = roleId;
	}

	@Column(name = "role", unique = true)
    private String role;

   

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

}
