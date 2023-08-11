package com.vincenzo.springbot.learnjpaandhibernate.course;

import com.vincenzo.springbot.learnjpaandhibernate.course.jdbc.CourseJdbcRepository;
import com.vincenzo.springbot.learnjpaandhibernate.course.jpa.CourseJpaRepository;
import com.vincenzo.springbot.learnjpaandhibernate.course.springdatajpa.CourseSpringDataJpaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class CourseCommandLineRunner implements CommandLineRunner {
    //@Autowired
    //private CourseJdbcRepository repository;

    //@Autowired
    //private CourseJpaRepository repository;
    @Autowired
    private CourseSpringDataJpaRepository repository;
    @Override
    public void run(String... args) throws Exception {
        repository.save(new Course(1, "Learn AWS Now!", "Mammt"));
        repository.save(new Course(2, "Learn Azure Now!", "Mammt"));
        repository.save(new Course(3, "Learn DevOps Now!", "Mammt"));

        repository.deleteById(1L);

        System.out.println(repository.findById(2L));
        System.out.println(repository.findById(3L));

        System.out.println(repository.findAll());
        System.out.println(repository.count());

        System.out.println(repository.findByAuthor("Mammt"));
    }
}
