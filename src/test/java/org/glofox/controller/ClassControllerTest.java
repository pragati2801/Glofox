package org.glofox.controller;

import org.glofox.model.Class;
import org.glofox.service.ClassService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.*;


public class ClassControllerTest {
    @InjectMocks
    private ClassController classController;

    @Mock
    private ClassService classService;

    private Class clazz;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
        clazz = new Class(1L, "Yoga", new java.util.Date(), new java.util.Date(), 10);
    }

    @Test
    public void createClass_ShouldReturnClass_WhenValid() {
        when(classService.createClass(any(Class.class))).thenReturn(clazz);

        Class createdClass = classController.createClass(clazz).getBody();

        assertNotNull(createdClass);
        assertEquals(clazz.getClassId(), createdClass.getClassId());

    }

    @Test
    public void getClassById_ShouldReturnClass_WhenExists() {
        when(classService.getClassById(anyLong())).thenReturn(clazz);

        Class foundClass = classController.getClass(1L).getBody();

        assertNotNull(foundClass);
        assertEquals(clazz.getClassId(), foundClass.getClassId());
        verify(classService, times(1)).getClassById(1L);
    }


}
