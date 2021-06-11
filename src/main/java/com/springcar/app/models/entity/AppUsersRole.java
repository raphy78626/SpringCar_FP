package com.springcar.app.models.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;


@Entity
@Table(name = "AppUsersRoles")

@NamedQueries({
	@NamedQuery(name = AppUsersRole.GET_USER_ROLE_LIST, query = "select u from AppUsersRole u where u.id =:userID")
})
public class AppUsersRole implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	protected static final String GET_USER_ROLE_LIST = "GET_USER_ROLE_LIST";
	
	@Id
	@Column(name = "userId")
	private Long userId;
	
	


	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public Long getRoleId() {
		return roleId;
	}

	public void setRoleId(Long roleId) {
		this.roleId = roleId;
	}

	@Id
	@Column(name = "roleId")
	private Long roleId;

}
