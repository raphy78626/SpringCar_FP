package com.springcar.app.repository;

import com.springcar.app.models.entity.User;

public interface UserRepositoryCustom {

	public User getUserById(Long userId);

	public User getUserByEmail(String email);
	
	public User addUser(User user);
	
//	public int updateUser(String userlogin, User userUpdate);
	
	public void addRoleToUser(Long userId, Long roleId);

}
