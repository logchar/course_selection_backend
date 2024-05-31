package com.course.backend.service;

import com.course.backend.entity.Course;
import com.course.backend.entity.Teacher;
import com.course.backend.repository.CourseRepository;
import com.course.backend.repository.TeacherRepository;
import com.course.backend.utils.R;
import com.course.backend.utils.ResultCode;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.MissingResourceException;
import java.util.Optional;


@Service
public class CourseService {

    @Autowired
    private CourseRepository courseRepository;

    @Autowired
    private TeacherRepository teacherRepository;

    public R saveCourse(Course course) {
        courseRepository.save(course);
        return R.success(ResultCode.SUCCESS, null);
    }

    public R findCourseById(Long id) {
        Optional<Course> course = courseRepository.findById(id);
        if (course.isPresent()) {
            return R.success(ResultCode.SUCCESS, course.get());
        } else {
            return R.error(ResultCode.FAIL, "Course not found");
        }
    }

    public R findAllCourses() {
        List<Course> courses = courseRepository.findAll();
        return R.success(ResultCode.SUCCESS, courses);
    }

    public R updateCourse(Course course) {
        courseRepository.save(course);
        return R.success(ResultCode.SUCCESS, null);
    }

    public R deleteCourseById(Long id) {
        courseRepository.deleteById(id);
        return R.success(ResultCode.SUCCESS, null);
    }

    @Transactional
    public R courseGetTeacher(Long courseId, Long teacherId) {
        Teacher teacher = teacherRepository.findById(teacherId)
                .orElseThrow(() -> new MissingResourceException("teacher not found", "Teacher", "teacherId"));
        Course course = courseRepository.findById(courseId)
                .orElseThrow(() -> new MissingResourceException("course not found", "Course", "courseId"));
        course.setTeacher(teacher);
        courseRepository.save(course);
        return R.success(ResultCode.SUCCESS, null);
    }

}
