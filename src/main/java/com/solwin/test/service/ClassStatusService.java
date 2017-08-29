package com.solwin.test.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.solwin.test.dao.IClassStatusDAO;
import com.solwin.test.entity.ClassStatus;

@Service
public class ClassStatusService implements IClassStatusService {
	@Autowired
	private IClassStatusDAO classStatusDAO;
	
	@Override
	public List<ClassStatus> getAllClassStatus() {
		return classStatusDAO.getAllClassStatus();
	}

	@Override
	public ClassStatus getClassStatusById(int classStatusId) {
		return classStatusDAO.getClassStatusById(classStatusId);
	}
}
