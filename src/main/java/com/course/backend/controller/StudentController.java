package com.course.backend.controller;
import com.course.backend.entity.Student;
import com.course.backend.service.StudentService;
import com.course.backend.utils.R;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/students")

public class StudentController {

    @Autowired
    private StudentService studentService;

    @PostMapping
    public R createCourse(@RequestBody Student course) {
        return studentService.saveStudent(course);
    }

}
