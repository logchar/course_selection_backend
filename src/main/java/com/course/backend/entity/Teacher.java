package com.course.backend.entity;

import lombok.Data;

import jakarta.persistence.*;
import java.util.List;


@Entity
@Data
@Table(name = "teachers")
public class Teacher {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "teacher_name", nullable = false, length = 50)
    private String teacher_name;

    @Column(name = "title", length = 50)
    private String title;

    @Column(name = "password", length = 20)
    private String password;

    @Column(name = "is_admin", columnDefinition = "BOOLEAN DEFAULT FALSE")
    private Boolean is_admin;

    @OneToMany(mappedBy = "teacher")
    private List<Course> courses;

}
