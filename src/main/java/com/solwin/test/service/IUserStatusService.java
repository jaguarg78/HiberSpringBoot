package com.solwin.test.service;

import java.util.List;

import com.solwin.test.entity.UserStatus;

public interface IUserStatusService {
    List<UserStatus> getAllUserStatus();
    UserStatus getUserStatusById(int userStatusId);
}
