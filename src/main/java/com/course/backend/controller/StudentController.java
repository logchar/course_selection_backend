package com.course.backend.controller;
import com.course.backend.entity.Student;
import com.course.backend.service.StudentService;
import com.course.backend.utils.R;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/students")
public class StudentController {

    @Autowired
    private StudentService studentService;

    @PostMapping("/login")
    public R loginStudent(@RequestBody String password, @RequestBody String school_number) {
        return studentService.loginStudent(password, school_number);
    }

    @PostMapping
    public R createStudent(@RequestBody Student student) {
        return studentService.saveStudent(student);
    }

    @GetMapping
    public R getAllStudents() { return studentService.findAllStudents(); }

    @GetMapping("/{id}")
    public R getStudentById(@PathVariable Long id) {
        return studentService.findStudentById(id);
    }

    @PutMapping("/{id}")
    public R updateStudent(@PathVariable Long id, @RequestBody Student student) {
        student.setId(id);
        return studentService.updateStudent(student);
    }

    @DeleteMapping("/{id}")
    public R deleteStudent(@PathVariable Long id) {
        return studentService.deleteStudentById(id);
    }

    @PostMapping("/{studentId}/courses")
    @Operation(summary = "学生选课", description = "路由中传入选课的学生id，请求体中传入一个选课课程id的列表")
    public R studentSelectCourses(@PathVariable Long studentId, @RequestBody List<Long> courseIds) {
        return studentService.studentSelectCourses(studentId, courseIds);
    }

}
