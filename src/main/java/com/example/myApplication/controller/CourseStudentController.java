package com.example.myApplication.controller;

import com.example.myApplication.model.Course;
import com.example.myApplication.model.Student;
import com.example.myApplication.service.AddCourseToStudent;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("myApp/studentCourse")
public class CourseStudentController {

    @Autowired
    private AddCourseToStudent addCourseToStudent;

    @GetMapping(path="/addCourseToStudent")
    public Student addCourseToStudent(@RequestParam int courseId, @RequestParam int studentId){
       return addCourseToStudent.addCourse(courseId,studentId);

    }
}
