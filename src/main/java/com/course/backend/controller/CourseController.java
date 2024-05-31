package com.course.backend.controller;

import com.course.backend.entity.Course;
import com.course.backend.service.CourseService;
import com.course.backend.utils.R;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/courses")
public class CourseController {

    @Autowired
    private CourseService courseService;

    @PostMapping
    public R createCourse(@RequestBody Course course) {
        return courseService.saveCourse(course);
    }

    @GetMapping
    public R getAllCourses() { return courseService.findAllCourses(); }

    @GetMapping("/{id}")
    public R getCourseById(@PathVariable Long id) {
        return courseService.findCourseById(id);
    }

    @PutMapping("/{id}")
    public R updateCourse(@PathVariable Long id, @RequestBody Course course) {
        course.setId(id);
        return courseService.updateCourse(course);
    }

    @DeleteMapping("/{id}")
    public R deleteCourse(@PathVariable Long id) {
        return courseService.deleteCourseById(id);
    }

    @PostMapping("/{courseId}/teacher")
    @Operation(summary = "将老师绑定到课", description = "路由中传入课程id，请求体中传入老师id，将其绑定")
    public R courseGetTeacher(@PathVariable Long courseId, @RequestBody Long teacherId) {
        return courseService.courseGetTeacher(courseId, teacherId);
    }

}
