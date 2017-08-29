package com.solwin.test.service;

import java.math.BigInteger;
import java.util.List;

import com.solwin.test.entity.User;

public interface IUserService {
    List<User> getAllUsers();
    User getUserById(BigInteger userId);
    boolean addUser(User user);
    void updateUser(User user);
    void deleteUser(BigInteger userId);
}
