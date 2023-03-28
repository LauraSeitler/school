package org.ironhack.bootcamp.jpt13.school.school.Repository;

import org.ironhack.bootcamp.jpt13.school.school.models.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepository extends JpaRepository<Student,Long>{
}
