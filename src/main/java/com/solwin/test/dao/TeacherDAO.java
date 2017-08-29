package com.solwin.test.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.solwin.test.entity.Teacher;

@Transactional
@Repository
public class TeacherDAO implements ITeacherDAO {
	@PersistenceContext
	private EntityManager entityManager;
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Teacher> getAllTeachers() {
		String hql = "FROM Teacher AS tch ORDER BY tch.id";
		return (List<Teacher>) entityManager.createQuery(hql).getResultList();
	}

	@Override
	public Teacher getTeacherById(int teacherId) {
		return entityManager.find(Teacher.class, teacherId);
	}

	@Override
	public void addTeacher(Teacher teacher) {
		entityManager.persist(teacher);
	}

	@Override
	public void updateTeacher(Teacher teacher) {
		Teacher tch = getTeacherById(teacher.getId());
		tch.setUser(teacher.getUser());
		entityManager.flush();
	}

	@Override
	public void deleteTeacher(int teacherId) {
		entityManager.remove(getTeacherById(teacherId));
	}

	@Override
	public boolean teacherExists(Teacher teacher) {
		return entityManager
						.createQuery("FROM Teacher AS tch "+
		                            "WHERE tch.id = ? ")
							.setParameter(1, teacher.getId())
								.getResultList().size() > 0;
	}
	
}
