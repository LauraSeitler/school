package org.ironhack.bootcamp.jpt13.school.school.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Entity
public class Course {
    @Id
    private String course_code;
    private String course_name;

    //constructor, getters, and setters omitted for brevity

    public Course(String course_code, String course_name) {
        this.course_code = course_code;
        this.course_name = course_name;
    }

    public String getCourse_code() {
        return course_code;
    }

    public void setCourse_code(String course_code) {
        this.course_code = course_code;
    }

    public String getCourse_name() {
        return course_name;
    }

    public void setCourse_name(String course_name) {
        this.course_name = course_name;
    }
}