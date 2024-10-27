package org.glofox.repository;

import org.glofox.model.Class;
import org.glofox.model.User;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class ClassRepository {
    private final List<Class> classes = new ArrayList<>();

    public Class save(Class newClass) {
        classes.add(newClass);
        return  newClass;
    }

    public List<Class> findAll() {
        return classes;
    }
    public Class findClassById(Long classId)
    {
        return classes.stream().filter(x->
                x.getClassId().equals(classId)).findFirst().get();
    }
}
