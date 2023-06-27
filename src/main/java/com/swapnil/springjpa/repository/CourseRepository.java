package com.swapnil.springjpa.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.swapnil.springjpa.entity.Course;

@Repository
public interface CourseRepository extends JpaRepository<Course, Long> {
    
}
