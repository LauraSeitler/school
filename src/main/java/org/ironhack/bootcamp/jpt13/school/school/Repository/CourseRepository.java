package org.ironhack.bootcamp.jpt13.school.school.Repository;

import org.ironhack.bootcamp.jpt13.school.school.models.Course;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CourseRepository extends JpaRepository<Course, String> {

}
