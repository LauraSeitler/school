package org.ironhack.bootcamp.jpt13.school.school.services;

public interface StudentService {
    List<Student> list();
    Student create (Student student);
    void updateStudent(Long id, Student student);
}
