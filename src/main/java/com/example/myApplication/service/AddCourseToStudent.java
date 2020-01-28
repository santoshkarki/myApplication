package com.example.myApplication.service;

import com.example.myApplication.model.Course;
import com.example.myApplication.model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Optional;
import java.util.Set;

@Service
public class AddCourseToStudent {

    @Autowired
    private IStudentService studentService;

    @Autowired
    private ICourseService courseService;

    public Student addCourse(int courseId, int studentId){
        Optional<Student> student = studentService.retrieveStudent(studentId);
        Optional<Course> course = courseService.retrieveCourse(courseId);
        Student s1 = new Student();
        Set<Course> courses;
       Course c1;
       if(student.isPresent()){
           s1= student.get();
       }

        if(student.isPresent() && course.isPresent()){
           courses = s1.getCourses();
           c1=course.get();

           courses.add(c1);

        }
        return studentService.updateStudent(studentId,s1);
    }
}
