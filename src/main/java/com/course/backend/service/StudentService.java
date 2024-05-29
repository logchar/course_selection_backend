package com.course.backend.service;

import com.course.backend.entity.Student;
import com.course.backend.repository.StudentRepository;
import com.course.backend.utils.R;
import com.course.backend.utils.ResultCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StudentService {

    @Autowired
    private StudentRepository studentRepository;

    public R saveStudent(Student student) {
        studentRepository.save(student);
        return R.success(ResultCode.SUCCESS, null);
    }

}
