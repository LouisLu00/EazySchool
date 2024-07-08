package com.louis.EazySchool.Repository;

import com.louis.EazySchool.model.Courses;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CourseRepository extends JpaRepository<Courses, Integer> {
    List<Courses> findByOrderByNameDesc();
    List<Courses> findByOrderByName();
}
