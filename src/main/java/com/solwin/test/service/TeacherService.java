package com.solwin.test.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.solwin.test.dao.ITeacherDAO;
import com.solwin.test.entity.Teacher;

@Service
public class TeacherService implements ITeacherService {
	@Autowired
	private ITeacherDAO teacherDAO;
	
	@Override
	public List<Teacher> getAllTeachers() {
		return teacherDAO.getAllTeachers();
	}

	@Override
	public Teacher getTeacherById(int teacherId) {
		return teacherDAO.getTeacherById(teacherId);
	}

	@Override
	public boolean addTeacher(Teacher teacher) {
		if (teacherDAO.teacherExists(teacher)) {
            return false;
        }
		
		teacherDAO.addTeacher(teacher);
        return true;
	}

	@Override
	public void updateTeacher(Teacher teacher) {
		teacherDAO.updateTeacher(teacher);
	}

	@Override
	public void deleteTeacher(int teacherId) {
		teacherDAO.deleteTeacher(teacherId);
	}
}
