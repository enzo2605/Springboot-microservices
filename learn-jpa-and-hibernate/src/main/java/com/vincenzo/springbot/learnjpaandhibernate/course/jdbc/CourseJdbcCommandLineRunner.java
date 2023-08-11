package com.vincenzo.springbot.learnjpaandhibernate.course.jdbc;

import com.vincenzo.springbot.learnjpaandhibernate.course.Course;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class CourseJdbcCommandLineRunner implements CommandLineRunner {
    @Autowired
    private CourseJdbcRepository repository;
    @Override
    public void run(String... args) throws Exception {
        repository.insert(new Course(1, "Learn AWS Now!", "Mammt"));
        repository.insert(new Course(2, "Learn Azure Now!", "Mammt"));
        repository.insert(new Course(3, "Learn DevOps Now!", "Mammt"));
        repository.delete(1);
    }
}
