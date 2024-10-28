package org.glofox.service.impl;

import org.glofox.model.Class;
import org.glofox.repository.ClassRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.*;

public class ClassServiceImplTest {
    @InjectMocks
    private ClassServiceImpl classService;

    @Mock
    private ClassRepository classRepository;

    private Class clazz;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);

        clazz = new Class(1L, "Yoga", new java.util.Date(), new java.util.Date(), 10);
    }

    @Test
    public void createClass_ShouldReturnClass_WhenValid() {
        when(classRepository.save(any(Class.class))).thenReturn(clazz);

        Class createdClass = classService.createClass(clazz);

        assertNotNull(createdClass);
        assertEquals(clazz.getClassId(), createdClass.getClassId());
        verify(classRepository, times(1)).save(clazz);
    }

    @Test
    public void getClassById_ShouldReturnClass_WhenExists() {
        when(classRepository.findClassById(1L)).thenReturn(clazz);

        Class foundClass = classService.getClassById(1L);

        assertNotNull(foundClass);
        assertEquals(clazz.getClassId(), foundClass.getClassId());
        verify(classRepository, times(1)).findClassById(1L);
    }

    @Test
    public void getAllClasses_ShouldReturnListOfClasses() {
        when(classRepository.findAll()).thenReturn(List.of(clazz));

        List<Class> classes = classService.getAllClasses();

        assertNotNull(classes);
        assertEquals(1, classes.size());
        verify(classRepository, times(1)).findAll();
    }
}
