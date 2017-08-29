package com.solwin.test.dao;

import java.util.List;

import com.solwin.test.entity.ClassStatus;

public interface IClassStatusDAO {
    List<ClassStatus> getAllClassStatus();
    ClassStatus getClassStatusById(int classStatusId);
    boolean classStatusExists(ClassStatus classStatus);
}
