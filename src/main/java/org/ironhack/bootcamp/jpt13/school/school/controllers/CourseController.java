package org.ironhack.bootcamp.jpt13.school.school.controllers;

import org.ironhack.bootcamp.jpt13.school.school.models.Course;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class CourseController implements CourseControllerInterface {

    @GetMapping("/courses")
    @ResponseStatus(HttpStatus.OK)
    public List<Course> getCourses() {
       // return courseRepository.findAll();


        //this would typically be a call to your data or service layer
        List<Course> courseList = new ArrayList<>();

        courseList.add(new Course("MA101", "College Algebra"));
        courseList.add(new Course("MA102", "Calculus 1"));

        return courseList;
    }
    @GetMapping("/course/{name}")
    @ResponseStatus(HttpStatus.OK)
    public List<Course> getCoursesByNamePathVariable(@PathVariable name) {
        return courseRepository.findByCourseName(name);
    }

    @GetMapping("/course")
    @ResponseStatus(HttpStatus.OK)
    public List<Course> getCoursesByNameQueryParam(@RequestParam String name) {
        return courseRepository.findByCourseName(name);
    }


    public CourseController() {
    }
}