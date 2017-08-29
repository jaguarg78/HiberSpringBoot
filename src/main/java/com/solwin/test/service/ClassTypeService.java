package com.solwin.test.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.solwin.test.dao.IClassTypeDAO;
import com.solwin.test.entity.ClassType;

@Service
public class ClassTypeService implements IClassTypeService {
	@Autowired
	private IClassTypeDAO classTypeDAO;
	
	@Override
	public List<ClassType> getAllClassTypes() {
		return classTypeDAO.getAllClassTypes();
	}

	@Override
	public ClassType getClassTypeById(int classTypeId) {
		return classTypeDAO.getClassTypeById(classTypeId);
	}

	@Override
	public boolean addClassType(ClassType classType) {
		if (classTypeDAO.classTypeExists(classType)) {
            return false;
        }
		
		classTypeDAO.addClassType(classType);
        return true;
	}

	@Override
	public void updateClassType(ClassType classType) {
		classTypeDAO.updateClassType(classType);
	}

	@Override
	public void deleteClassType(int classTypeId) {
		classTypeDAO.deleteClassType(classTypeId);
	}
}
