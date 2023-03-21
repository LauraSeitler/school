package org.ironhack.bootcamp.jpt13.school.school.models;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class CourseController implements CourseControllerInterface {

    @GetMapping("/courses")
    @ResponseStatus(HttpStatus.OK)
    public List<Course> getCourses() {
       // return courseReposotiry.findAll();

        @Autowired
        //this would typically be a call to your data or service layer
        List<Course> courseList = new ArrayList<>();

        courseList.add(new Course("MA101", "College Algebra"));
        courseList.add(new Course("MA102", "Calculus 1"));

        return courseList;
    }

    public CourseController() {
    }
}