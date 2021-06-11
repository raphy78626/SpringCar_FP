package com.springcar.app.repository;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Repository;

import com.springcar.app.models.dao.UserRoleRepository;
import com.springcar.app.models.entity.AppUsersRole;
import com.springcar.app.models.entity.User;

@Repository
public class UserRepositoryImpl implements UserRepositoryCustom {

	@PersistenceContext
	private EntityManager entityManager;



	@Autowired
	private UserRoleRepository userRoleRepository;



	@Override
	public User getUserById(Long userId) {
		User result = null;

		try {
			result = (User) entityManager
					.createQuery("SELECT u FROM Users u LEFT JOIN FETCH u.userRolesList WHERE u.id=:userId")
					.setParameter("userId", userId).getSingleResult();
		} catch (NoResultException nre) {
		}

		return result;
	}

	@Override
	public User getUserByEmail(String email) {
		User result = null;

		try {
			result = (User) entityManager
					.createQuery("SELECT u FROM Users u  WHERE u.email=:emailp")
					.setParameter("emailp", email).getSingleResult();
		} catch (NoResultException nre) {
		}

		return result;
	}

	@Override
	@Transactional
	public User addUser(User userToPersist) {
		long customerRoleId = 2;
		entityManager.persist(userToPersist);
		AppUsersRole appUserRole = new AppUsersRole();
		appUserRole.setUserId(userToPersist.getId());
		appUserRole.setRoleId(customerRoleId);
		entityManager.persist(appUserRole);
		return userToPersist;
	}

	@Override
	@Transactional
	public void addRoleToUser(Long userId, Long roleId) {
		User userToAddRole = getUserById(userId);

		userToAddRole.getUserRolesList().add(userRoleRepository.getUserRoleById(roleId));

		entityManager.merge(userToAddRole);
	}

	/*
	 * @Override
	 * 
	 * @Transactional public int updateUser(String userlogin, User userUpdate) {
	 * 
	 * if(userUpdate.getPassword()==null) { System.out.println("test"); }
	 * 
	 * System.out.println(userlogin);
	 * 
	 * int number = entityManager .createQuery("UPDATE User u SET " +
	 * "u.name=COALESCE(:name,u.name), " +
	 * "u.surname=COALESCE(:surname,u.surname), " +
	 * "u.password=COALESCE(:password,u.password), " +
	 * "u.email=COALESCE(:email,u.email), " + "u.phone=COALESCE(:phone,u.phone), " +
	 * "u.birthDate=COALESCE(:birthDate,u.birthDate), " +
	 * "u.pesel=COALESCE(:pesel,u.pesel) " + "WHERE u.login=:login")
	 * .setParameter("name", userUpdate.getName()) .setParameter("surname",
	 * userUpdate.getSurname())
	 * .setParameter("password",userUpdate.getPassword()!=null ?
	 * passwordEncoder.encode(userUpdate.getPassword()) : userUpdate.getPassword())
	 * .setParameter("email", userUpdate.getEmail()) .setParameter("phone",
	 * userUpdate.getPhone()) .setParameter("birthDate", userUpdate.getBirthDate())
	 * .setParameter("pesel", userUpdate.getPesel()) .setParameter("login",
	 * userlogin) .executeUpdate();
	 * 
	 * return number; }
	 */
}
