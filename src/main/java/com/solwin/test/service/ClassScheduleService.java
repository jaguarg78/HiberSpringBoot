package com.solwin.test.service;

import java.math.BigInteger;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.solwin.test.dao.IClassScheduleDAO;
import com.solwin.test.entity.ClassSchedule;
import com.solwin.test.structures.Schedule;

@Service
public class ClassScheduleService implements IClassScheduleService {
	@Autowired
	private IClassScheduleDAO classScheduleDAO;
	
	@Override
	public ClassSchedule getClassScheduleById(BigInteger classScheduleId) {
		return classScheduleDAO.getClassScheduleById(classScheduleId);
	}

	@Override
	public List<ClassSchedule> getClassSchedulesByParams(Schedule schedule) {
		return classScheduleDAO.getClassSchedulesByParams(schedule);
	}

	@Override
	public boolean addClassSchedule(ClassSchedule classSchedule) {
		if (classScheduleDAO.classScheduleExists(classSchedule)) {
            return false;
        }
		
		classScheduleDAO.addClassSchedule(classSchedule);
        return true;
	}

	@Override
	public void updateClassSchedule(ClassSchedule classSchedule) {
		classScheduleDAO.updateClassSchedule(classSchedule);
	}

	@Override
	public void deleteClassSchedule(BigInteger classScheduleId) {
		classScheduleDAO.deleteClassSchedule(classScheduleId);
	}

	
}
