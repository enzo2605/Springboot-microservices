package com.vincenzo.springbot.learnjpaandhibernate.course.springdatajpa;

import com.vincenzo.springbot.learnjpaandhibernate.course.Course;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CourseSpringDataJpaRepository extends JpaRepository<Course, Long> {
    public List<Course> findByAuthor (String author);
}
