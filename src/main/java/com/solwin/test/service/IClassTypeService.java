package com.solwin.test.service;

import java.util.List;

import com.solwin.test.entity.ClassType;

public interface IClassTypeService {
    List<ClassType> getAllClassTypes();
    ClassType getClassTypeById(int classTypeId);
    boolean addClassType(ClassType classType);
    void updateClassType(ClassType classType);
    void deleteClassType(int classTypeId);
}
