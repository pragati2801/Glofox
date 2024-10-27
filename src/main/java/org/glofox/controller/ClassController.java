package org.glofox.controller;

import lombok.extern.slf4j.Slf4j;
import org.glofox.model.Class;
import org.glofox.service.ClassService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping("v1/class")
public class  ClassController {
    @Autowired
    ClassService classService;

    @GetMapping()
    public ResponseEntity<Class> getClass(@RequestParam("classId")  Long classId )
    {
        return ResponseEntity.ok(classService.getClassById(classId));

    }

    @PostMapping()
    public ResponseEntity<Class> createClass(@RequestBody Class classObj)
    {
        classService.createClass(classObj);
        return ResponseEntity.ok(classService.createClass(classObj));

    }
}
