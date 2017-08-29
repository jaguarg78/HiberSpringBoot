package com.solwin.test.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.solwin.test.entity.UserStatus;

@Transactional
@Repository
public class UserStatusDAO implements IUserStatusDAO {
	@PersistenceContext
	private EntityManager entityManager;
	
	@SuppressWarnings("unchecked")
	@Override
	public List<UserStatus> getAllUserStatus() {
		String hql = "FROM UserStatus AS ust WHERE ust.name != ? ORDER BY ust.id";
		return (List<UserStatus>) entityManager
									.createQuery(hql)
										.setParameter(1, "CREATED")
											.getResultList();
	}

	@Override
	public UserStatus getUserStatusById(int userStatusId) {
		return entityManager.find(UserStatus.class, userStatusId);
	}

	@Override
	public boolean userStatusExists(UserStatus userStatus) {
		return entityManager
						.createQuery("FROM UserStatus AS ust "+
		                            "WHERE ust.id = ? ")
							.setParameter(1, userStatus.getId())
								.getResultList().size() > 0;
	}
	
}
