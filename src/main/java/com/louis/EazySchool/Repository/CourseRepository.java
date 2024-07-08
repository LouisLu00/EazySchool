package com.louis.EazySchool.Repository;

import com.louis.EazySchool.model.Courses;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CourseRepository extends JpaRepository<Courses, Integer> {
}
