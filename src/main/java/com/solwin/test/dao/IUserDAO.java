package com.solwin.test.dao;

import java.math.BigInteger;
import java.util.List;

import com.solwin.test.entity.User;

public interface IUserDAO {
    List<User> getAllUsers();
    User getUserById(BigInteger userId);
    void addUser(User user);
    void updateUser(User user);
    void deleteUser(BigInteger userId);
    boolean userExists(User user);
}
