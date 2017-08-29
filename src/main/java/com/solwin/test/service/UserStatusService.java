package com.solwin.test.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.solwin.test.dao.IUserStatusDAO;
import com.solwin.test.entity.UserStatus;

@Service
public class UserStatusService implements IUserStatusService {
	@Autowired
	private IUserStatusDAO userStatusDAO;
	
	@Override
	public List<UserStatus> getAllUserStatus() {
		return userStatusDAO.getAllUserStatus();
	}

	@Override
	public UserStatus getUserStatusById(int userStatusId) {
		return userStatusDAO.getUserStatusById(userStatusId);
	}
}
