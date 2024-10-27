package org.glofox.service;

import org.glofox.model.Class;

import java.util.List;

public interface ClassService {
    Class createClass(Class newClass);
    List<Class> getAllClasses();

    Class getClassById(Long classId);
}
