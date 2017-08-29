package com.solwin.test.service;

import java.math.BigInteger;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.solwin.test.dao.IUserDAO;
import com.solwin.test.entity.User;

@Service
public class UserService implements IUserService {
	@Autowired
	private IUserDAO userDAO;
	
	@Override
	public List<User> getAllUsers() {
		return userDAO.getAllUsers();
	}

	@Override
	public User getUserById(BigInteger userId) {
		return userDAO.getUserById(userId);
	}

	@Override
	public boolean addUser(User user) {
		if (userDAO.userExists(user)) {
            return false;
        }
		
		userDAO.addUser(user);
        return true;
	}

	@Override
	public void updateUser(User user) {
		userDAO.updateUser(user);
	}

	@Override
	public void deleteUser(BigInteger userId) {
		userDAO.deleteUser(userId);
	}

}
