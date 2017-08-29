package com.solwin.test.dao;

import java.util.List;

import com.solwin.test.entity.ClassType;

public interface IClassTypeDAO {
    List<ClassType> getAllClassTypes();
    ClassType getClassTypeById(int classTypeId);
    void addClassType(ClassType classType);
    void updateClassType(ClassType classType);
    void deleteClassType(int classTypeId);
    boolean classTypeExists(ClassType classType);
}
