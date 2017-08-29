package com.solwin.test.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.solwin.test.entity.ClassType;

@Transactional
@Repository
public class ClassTypeDAO implements IClassTypeDAO {
	@PersistenceContext
	private EntityManager entityManager;
	
	@SuppressWarnings("unchecked")
	@Override
	public List<ClassType> getAllClassTypes() {
		String hql = "FROM ClassType AS ct ORDER BY ct.id";
		return (List<ClassType>) entityManager.createQuery(hql).getResultList();
	}

	@Override
	public ClassType getClassTypeById(int classTypeId) {
		return entityManager.find(ClassType.class, classTypeId);
	}

	@Override
	public void addClassType(ClassType classType) {
		entityManager.persist(classType);
	}

	@Override
	public void updateClassType(ClassType classType) {
		ClassType ct = getClassTypeById(classType.getId());
		ct.setName(classType.getName());
		ct.setDescription(classType.getDescription());
		ct.setSite(classType.getSite());

		entityManager.flush();
	}

	@Override
	public void deleteClassType(int classTypeId) {
		entityManager.remove(getClassTypeById(classTypeId));
	}

	@Override
	public boolean classTypeExists(ClassType classType) {
		return entityManager
						.createQuery("FROM ClassType AS ct "+
		                            "WHERE ct.name = ? ")
							.setParameter(1, classType.getName())
								.getResultList().size() > 0;
	}
}
