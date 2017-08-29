package com.solwin.test.dao;

import java.math.BigInteger;
import java.util.List;

import com.solwin.test.entity.ClassSchedule;
import com.solwin.test.structures.Schedule;

public interface IClassScheduleDAO {
    ClassSchedule getClassScheduleById(BigInteger classScheduleId);
    List<ClassSchedule> getClassSchedulesByParams(Schedule schedule);
    void addClassSchedule(ClassSchedule classSchedule);
    void updateClassSchedule(ClassSchedule classSchedule);
    void deleteClassSchedule(BigInteger classScheduleId);
    boolean classScheduleExists(ClassSchedule classSchedule);
}
