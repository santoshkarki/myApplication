package com.example.myApplication.service;

import com.example.myApplication.model.Course;

import java.util.List;
import java.util.Optional;

public interface ICourseService {
    public List<Course> retrieveCourses();
    public Optional<Course> retrieveCourse(int courseId);
    public Course addCourse(Course course);
    public Course updateCourse(int courseId,Course course);
    public String deleteCourse(int courseId);
}
