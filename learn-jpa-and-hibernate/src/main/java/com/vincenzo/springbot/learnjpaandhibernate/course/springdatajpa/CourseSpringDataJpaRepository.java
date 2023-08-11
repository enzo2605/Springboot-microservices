package com.vincenzo.springbot.learnjpaandhibernate.course.springdatajpa;

import com.vincenzo.springbot.learnjpaandhibernate.course.Course;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CourseSpringDataJpaRepository extends JpaRepository<Course, Long> {}
