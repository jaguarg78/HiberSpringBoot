package com.solwin.test.service;

import java.util.List;

import com.solwin.test.entity.ClassStatus;

public interface IClassStatusService {
    List<ClassStatus> getAllClassStatus();
    ClassStatus getClassStatusById(int classStatusId);
}
