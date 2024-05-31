package com.course.backend.controller;

import com.course.backend.entity.Teacher;
import com.course.backend.service.TeacherService;
import com.course.backend.utils.R;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/teachers")
public class TeacherController {

    @Autowired
    private TeacherService teacherService;

    @PostMapping
    public R createTeacher(@RequestBody Teacher teacher) {
        return teacherService.saveTeacher(teacher);
    }

    @GetMapping
    public R getAllTeachers() { return teacherService.findAllTeachers(); }

    @GetMapping("/{id}")
    public R getTeacherById(@PathVariable Long id) {
        return teacherService.findTeacherById(id);
    }

    @PutMapping("/{id}")
    public R updateTeacher(@PathVariable Long id, @RequestBody Teacher teacher) {
        teacher.setId(id);
        return teacherService.updateTeacher(teacher);
    }

    @DeleteMapping("/{id}")
    public R deleteStudent(@PathVariable Long id) {
        return teacherService.deleteTeacherById(id);
    }

}
