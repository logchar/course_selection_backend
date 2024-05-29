package com.course.backend;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;


@SpringBootApplication
@EntityScan(basePackages = "com.course.backend.entity")
@EnableJpaRepositories(basePackages = "com.course.backend.repository")
public class CourseSelectApplication {

    public static void main(String[] args) {
        SpringApplication.run(CourseSelectApplication.class,args);
    }

}
