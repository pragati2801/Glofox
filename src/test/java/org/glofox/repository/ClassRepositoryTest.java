package org.glofox.repository;

import org.glofox.model.Class;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ClassRepositoryTest {
    private ClassRepository classRepository;

    @BeforeEach
    public void setUp() {
        classRepository = new ClassRepository();
    }

    @Test
    public void save_ShouldAddClass_WhenCalled() {
        Class classObj = new Class(1L, "Yoga", null, null, 20);
        classRepository.save(classObj);

        assertEquals(1, classRepository.findAll().size());
        assertEquals(classObj, classRepository.findAll().get(0));
    }

    @Test
    public void findAll_ShouldReturnAllClasses() {
        Class class1 = new Class(1L, "Yoga", null, null, 20);
        Class class2 = new Class(2L, "Pilates", null, null, 15);

        classRepository.save(class1);
        classRepository.save(class2);

        assertEquals(2, classRepository.findAll().size());
    }

    @Test
    public void findClassById_ShouldReturnClass_WhenExists() {
        Class classObj = new Class(1L, "Yoga", null, null, 20);
        classRepository.save(classObj);

        Class foundClass = classRepository.findClassById(1L);

        assertEquals(classObj, foundClass);
    }
}
