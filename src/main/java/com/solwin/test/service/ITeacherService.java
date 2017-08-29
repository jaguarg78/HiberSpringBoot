package com.solwin.test.service;

import java.util.List;

import com.solwin.test.entity.Teacher;

public interface ITeacherService {
    List<Teacher> getAllTeachers();
    Teacher getTeacherById(int teacherId);
    boolean addTeacher(Teacher teacher);
    void updateTeacher(Teacher teacher);
    void deleteTeacher(int teacherId);
}
