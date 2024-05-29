package com.course.backend.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.Set;


@Entity
@Data
@Table(name = "courses")
public class Course {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "course_name", nullable = false, length = 100)
    private String course_name;

    @Column(name = "course_time", length = 50)
    private String course_time;

    @Column(name = "course_location", length = 100)
    private String course_location;

    @ManyToOne
    @Column(name = "teacher_id")
    private Teacher teacher;

    @ManyToMany(mappedBy = "courses")
    private Set<Student> students;

}
