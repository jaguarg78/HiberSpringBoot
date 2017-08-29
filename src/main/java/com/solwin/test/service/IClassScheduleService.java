package com.solwin.test.service;

import java.math.BigInteger;
import java.util.List;

import com.solwin.test.entity.ClassSchedule;
import com.solwin.test.structures.Schedule;

public interface IClassScheduleService {
    ClassSchedule getClassScheduleById(BigInteger classScheduleId);
    List<ClassSchedule> getClassSchedulesByParams(Schedule schedule);
    boolean addClassSchedule(ClassSchedule classSchedule);
    void updateClassSchedule(ClassSchedule classSchedule);
    void deleteClassSchedule(BigInteger classScheduleId);
}
