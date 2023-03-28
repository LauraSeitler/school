package org.ironhack.bootcamp.jpt13.school.school.services;

import org.ironhack.bootcamp.jpt13.school.school.Repository.StudentRepository;
import org.ironhack.bootcamp.jpt13.school.school.models.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class StudentServiceImpl implements StudentService{
    @Autowired
  private  StudentRepository studentRepository;
    @Override
    public List<Student>list();
    return studentRepository.findAll();
    @Override
    public Student create (Student student){
        return studentRepository.save(student);
    }
    @Override
    public void update (Long id, Student student){
        if (student.getId()!=id){
            return;
        }
        Optional<Student> studentOptional= StudentRepository.findById();

    }
}
