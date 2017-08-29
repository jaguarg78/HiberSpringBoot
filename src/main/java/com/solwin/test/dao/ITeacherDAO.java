package com.solwin.test.dao;

import java.util.List;

import com.solwin.test.entity.Teacher;

public interface ITeacherDAO {
    List<Teacher> getAllTeachers();
    Teacher getTeacherById(int teacherId);
    void addTeacher(Teacher teacher);
    void updateTeacher(Teacher teacher);
    void deleteTeacher(int teacherId);
    boolean teacherExists(Teacher teacher);
}
