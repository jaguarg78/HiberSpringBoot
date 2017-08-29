package com.solwin.test.dao;

import java.util.List;

import com.solwin.test.entity.UserStatus;

public interface IUserStatusDAO {
    List<UserStatus> getAllUserStatus();
    UserStatus getUserStatusById(int userStatusId);
    boolean userStatusExists(UserStatus userStatus);
}
