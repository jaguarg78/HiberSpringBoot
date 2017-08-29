package com.solwin.test.dao;

import java.math.BigInteger;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.solwin.test.entity.ClassSchedule;
import com.solwin.test.structures.Schedule;

@Transactional
@Repository
public class ClassScheduleDAO implements IClassScheduleDAO {
	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public ClassSchedule getClassScheduleById(BigInteger classScheduleId) {
		return entityManager.find(ClassSchedule.class, classScheduleId);
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<ClassSchedule> getClassSchedulesByParams(Schedule schedule) {
		String hql = " FROM ClassSchedule AS cls " +
				     "WHERE (? IS null OR cls.weekDay = ?) " +
				       "AND (? IS null OR cls.timeStart >= ?) " +
				       "AND (? IS null OR cls.timeEnd <= ?) " +
				       "AND (? IS null OR cls.teacherClass.date >= ?) " +
				       "AND (? IS null OR cls.teacherClass.date <= ?) " +
				       "AND (? IS null OR cls.place = ?) " +
				       "AND (? IS null OR cls.classType = ?) " +
				       "AND (? IS null OR cls.teacherClass.teacher = ?) " +
				       "AND (? IS null OR cls.users.id = ?) " +
				     "ORDER BY cls.id";
		
		return (List<ClassSchedule>) entityManager
								.createQuery(hql)
									.setParameter(1, schedule.getWok())
									.setParameter(2, schedule.getWok())
									.setParameter(3, schedule.getTimeFrom())
									.setParameter(4, schedule.getTimeFrom())
									.setParameter(5, schedule.getTimeTo())
									.setParameter(6, schedule.getTimeTo())
									.setParameter(7, schedule.getDateFrom())
									.setParameter(8, schedule.getDateFrom())
									.setParameter(9, schedule.getDateTo())
									.setParameter(10, schedule.getDateTo())
									.setParameter(11, schedule.getPlaceId())
									.setParameter(12, schedule.getPlaceId())
									.setParameter(13, schedule.getcTypeId())
									.setParameter(14, schedule.getcTypeId())
									.setParameter(15, schedule.getTeacherId())
									.setParameter(16, schedule.getTeacherId())
									.setParameter(17, schedule.getUserId())
									.setParameter(18, schedule.getUserId())
										.getResultList();
	}
	
	@Override
	public void addClassSchedule(ClassSchedule payment) {
		entityManager.persist(payment);
	}

	@Override
	public void updateClassSchedule(ClassSchedule classSchedule) {
		ClassSchedule cls = getClassScheduleById(classSchedule.getId());
		cls.setClassType(classSchedule.getClassType());
		cls.setPlace(classSchedule.getPlace());
		cls.setMaxCapacity(classSchedule.getMaxCapacity());
		cls.setEnrolls(classSchedule.getEnrolls());
		cls.setWeekDay(classSchedule.getWeekDay());
		cls.setTimeStart(classSchedule.getTimeStart());
		cls.setTimeEnd(classSchedule.getTimeEnd());
	
		entityManager.flush();
	}

	@Override
	public void deleteClassSchedule(BigInteger classScheduleId) {
		// TODO: Define delete process
		entityManager.remove(getClassScheduleById(classScheduleId));
	}
	
	@Override
	public boolean classScheduleExists(ClassSchedule classSchedule) {
		return entityManager
						.createQuery("FROM ClassSchedule AS cls "+
		                            "WHERE cls.id = ? ")
							.setParameter(1, classSchedule.getId())
								.getResultList().size() > 0;
	}
}
