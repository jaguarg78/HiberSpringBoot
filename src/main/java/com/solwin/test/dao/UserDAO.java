package com.solwin.test.dao;

import java.math.BigInteger;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.solwin.test.entity.User;

@Transactional
@Repository
public class UserDAO implements IUserDAO {
	@PersistenceContext
	private EntityManager entityManager;

	@SuppressWarnings("unchecked")
	@Override
	public List<User> getAllUsers() {
		String hql = "FROM User AS usr ORDER BY usr.id";
		return (List<User>) entityManager.createQuery(hql).getResultList();
	}

	@Override
	public User getUserById(BigInteger userId) {
		return entityManager.find(User.class, userId);
	}

	@Override
	public void addUser(User user) {
		entityManager.persist(user);
	}

	@Override
	public void updateUser(User user) {
		User usr = getUserById(user.getId());
		usr.setNames(usr.getNames());
		usr.setLastNames(usr.getLastNames());
		usr.setUsr(usr.getUsr());
		usr.setPswd(usr.getPswd());
		usr.setDocument(usr.getDocument());
		usr.setEmail(usr.getEmail());
		usr.setPhone(usr.getPhone());
		usr.setAddress(usr.getAddress());
		usr.setSubscription(usr.getSubscription());
		usr.setMedicalAuth(usr.getMedicalAuth());
		usr.setAvatar(usr.getAvatar());
		usr.setUserStatus(usr.getUserStatus());
		usr.setStatusTimestamp(usr.getStatusTimestamp());
		usr.setCreateTimestamp(usr.getCreateTimestamp());
		usr.setUpdateTimestamp(usr.getUpdateTimestamp());
		usr.setDeleteTimestamp(usr.getDeleteTimestamp());
	
		entityManager.flush();
	}

	@Override
	public void deleteUser(BigInteger userId) {
		entityManager.remove(getUserById(userId));
	}

	@Override
	public boolean userExists(User user) {
		return entityManager
				.createQuery("FROM User AS usr " +
						    "WHERE (usr.names = ? AND usr.lastNames = ? AND usr.document = ?) " +
				               "OR (usr.usr = ?)")
					.setParameter(1, user.getNames())
					.setParameter(2, user.getLastNames())
					.setParameter(3, user.getDocument())
					.setParameter(4, user.getUsr())
						.getResultList().size() > 0;
	}


}
