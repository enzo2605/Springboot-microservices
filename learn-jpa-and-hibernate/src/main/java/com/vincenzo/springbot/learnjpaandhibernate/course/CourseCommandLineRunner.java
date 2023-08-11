package com.vincenzo.springbot.learnjpaandhibernate.course;

import com.vincenzo.springbot.learnjpaandhibernate.course.jdbc.CourseJdbcRepository;
import com.vincenzo.springbot.learnjpaandhibernate.course.jpa.CourseJpaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class CourseCommandLineRunner implements CommandLineRunner {
    //@Autowired
    //private CourseJdbcRepository repository;
    @Autowired
    private CourseJpaRepository repository;
    @Override
    public void run(String... args) throws Exception {
        repository.insert(new Course(1, "Learn AWS Now!", "Mammt"));
        repository.insert(new Course(2, "Learn Azure Now!", "Mammt"));
        repository.insert(new Course(3, "Learn DevOps Now!", "Mammt"));

        repository.deleteById(1);

        System.out.println(repository.findById(2));
        System.out.println(repository.findById(3));
    }
}
