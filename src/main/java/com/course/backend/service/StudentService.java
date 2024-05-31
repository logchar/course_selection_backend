package com.course.backend.service;

import com.course.backend.entity.Course;
import com.course.backend.entity.Student;
import com.course.backend.repository.CourseRepository;
import com.course.backend.repository.StudentRepository;
import com.course.backend.utils.R;
import com.course.backend.utils.ResultCode;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.MissingResourceException;
import java.util.Optional;

@Service
public class StudentService {

    @Autowired
    private StudentRepository studentRepository;

    @Autowired
    private CourseRepository courseRepository;

    public R loginStudent(String password, String school_number) {
        List<Student> students = studentRepository.findBySchoolNumber(school_number);
        if (!students.isEmpty()) {
            Student student = students.get(0);
            if(student.getPassword()==password) {
                return R.success(ResultCode.USER_SUCCESS, student);
            } else {
                return R.error(ResultCode.USER_PASSWORD_ERROR, null);
            }
        } else {
            return R.error(ResultCode.USER_NOT_EXIST, null);
        }
    }

    public R saveStudent(Student student) {
        studentRepository.save(student);
        return R.success(ResultCode.SUCCESS, null);
    }

    public R findStudentById(Long id) {
        Optional<Student> studentOptional = studentRepository.findById(id);
        if (studentOptional.isPresent()) {
            return R.success(ResultCode.SUCCESS, studentOptional.get());
        } else {
            return R.error(ResultCode.FAIL, "Student not found");
        }
    }

    public R findAllStudents() {
        List<Student> students = studentRepository.findAll();
        return R.success(ResultCode.SUCCESS, students);
    }

    public R updateStudent(Student student) {
        studentRepository.save(student);
        return R.success(ResultCode.SUCCESS, null);
    }

    public R deleteStudentById(Long id) {
        studentRepository.deleteById(id);
        return R.success(ResultCode.SUCCESS, null);
    }

    @Transactional
    public R studentSelectCourses(Long studentId, List<Long> courseIds) {
        Student student = studentRepository.findById(studentId)
                .orElseThrow(() -> new MissingResourceException("student not found", "Student", "studentId"));
        for (Long courseId : courseIds) {
            Course course = courseRepository.findById(courseId)
                    .orElseThrow(() -> new MissingResourceException("course not found", "Course", "courseId"));

            course.getStudents().add(student);
            student.getCourses().add(course);
            courseRepository.save(course);
        }
        studentRepository.save(student);
        return R.success(ResultCode.SUCCESS, null);
    }

}
