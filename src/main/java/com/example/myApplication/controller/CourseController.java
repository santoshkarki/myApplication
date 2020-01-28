package com.example.myApplication.controller;

import com.example.myApplication.model.Course;
import com.example.myApplication.service.ICourseService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Slf4j
@RestController
@RequestMapping("/myApp/Courses")
public class CourseController {

    @Autowired
     private  ICourseService courseService;          //Autowire the interface not the implemented class

    @GetMapping(path={"","/"}, produces = "application/json")
    public List<Course> getCourses(){
        return courseService.retrieveCourses();
    }

    @GetMapping(value="/{courseId}",produces="application/json")
    public Optional<Course> getCourseByid(@PathVariable int courseId){
        return courseService.retrieveCourse(courseId);

    }

    @PostMapping(path="/addCourse",consumes="application/json", produces="application/json")
    public Course addCourse(@RequestBody Course course){
        return courseService.addCourse(course);
    }

    @PutMapping(path="/updateCourse",produces="application/json",consumes="application/json")
    public Course updateCourse(@RequestParam int courseId, @RequestBody Course course){
        return courseService.updateCourse(courseId,course);
    }

    @DeleteMapping(path="/delete",produces= MediaType.APPLICATION_JSON_VALUE)
    public String deleteCourse(@RequestParam int courseId){
        return courseService.deleteCourse(courseId);
    }

}
