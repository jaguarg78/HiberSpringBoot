package com.solwin.test.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.solwin.test.entity.ClassStatus;

@Transactional
@Repository
public class ClassStatusDAO implements IClassStatusDAO {
	@PersistenceContext
	private EntityManager entityManager;
	
	@SuppressWarnings("unchecked")
	@Override
	public List<ClassStatus> getAllClassStatus() {
		String hql = "FROM ClassStatus AS cst WHERE cst.name != ? ORDER BY ust.id";
		return (List<ClassStatus>) entityManager
									.createQuery(hql)
										.setParameter(1, "CREATED")
											.getResultList();
	}

	@Override
	public ClassStatus getClassStatusById(int classStatusId) {
		return entityManager.find(ClassStatus.class, classStatusId);
	}

	@Override
	public boolean classStatusExists(ClassStatus classStatus) {
		return entityManager
						.createQuery("FROM ClassStatus AS cst "+
		                            "WHERE cst.id = ? ")
							.setParameter(1, classStatus.getId())
								.getResultList().size() > 0;
	}
	
}
