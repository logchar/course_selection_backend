package com.course.backend.service;

import com.course.backend.entity.Teacher;
import com.course.backend.repository.TeacherRepository;
import com.course.backend.utils.R;
import com.course.backend.utils.ResultCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class TeacherService {

    @Autowired
    private TeacherRepository teacherRepository;

    public R saveTeacher(Teacher teacher) {
        teacherRepository.save(teacher);
        return R.success(ResultCode.SUCCESS, null);
    }

    public R findTeacherById(Long id) {
        Optional<Teacher> teacher = teacherRepository.findById(id);
        if (teacher.isPresent()) {
            return R.success(ResultCode.SUCCESS, teacher.get());
        } else {
            return R.error(ResultCode.FAIL, "Teacher not found");
        }
    }

    public R findAllTeachers() {
        List<Teacher> teachers = teacherRepository.findAll();
        return R.success(ResultCode.SUCCESS, teachers);
    }

    public R updateTeacher(Teacher teacher) {
        teacherRepository.save(teacher);
        return R.success(ResultCode.SUCCESS, null);
    }

    public R deleteTeacherById(Long id) {
        teacherRepository.deleteById(id);
        return R.success(ResultCode.SUCCESS, null);
    }

}
