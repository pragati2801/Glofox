package org.glofox.service.impl;

import lombok.extern.slf4j.Slf4j;

import org.glofox.model.Class;
import org.glofox.repository.ClassRepository;
import org.glofox.service.ClassService;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
public class ClassServiceImpl implements ClassService {
    ClassRepository classRepository;
    public ClassServiceImpl(ClassRepository classRepository) {
        this.classRepository = classRepository;
    }

    @Override
    public Class createClass(Class newClass) {
        log.info("Creating a new class: {}", newClass.getClassName());
        return classRepository.save(newClass);
    }

    @Override
    public List<Class> getAllClasses() {
        log.info("Fetching all classes");
        return classRepository.findAll();
    }
    @Override
    public Class getClassById(Long classId) {
        log.info("Fetching class for id {}" , classId);
        return classRepository.findClassById(classId);
    }
}
