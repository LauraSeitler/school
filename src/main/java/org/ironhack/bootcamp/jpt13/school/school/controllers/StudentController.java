package org.ironhack.bootcamp.jpt13.school.school.controllers;

import org.ironhack.bootcamp.jpt13.school.school.Repository.StudentRepository;
import org.ironhack.bootcamp.jpt13.school.school.models.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class StudentController implements StudentControllerInterface{
    @Autowired
    private StudentRepository studentRepository;

    @Override
    @GetMapping("/student")
    @ResponseStatus(HttpStatus.OK)
    public List<Student> list (){
        return studentRepository.findAll();
    }
    @Override
    @PostMapping("/student")
    @ResponseStatus(HttpStatus.CREATED)
    public Student create (@RequestBody Student student){
        return null;
    }
   
    
}
