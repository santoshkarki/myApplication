package com.example.myApplication.controller;

import com.example.myApplication.model.Student;
import com.example.myApplication.service.IStudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/myApp/students")
public class StudentController {

    @Autowired
    private IStudentService studentService;

    @GetMapping(path={"","/"})
    public List<Student> getStudents(){
        return studentService.retrieveAllStudents();
    }

    @GetMapping(path="/{studentId}")
    public Optional<Student> getStudent(@PathVariable int studentId){
        return studentService.retrieveStudent(studentId);
    }

    @PostMapping(path="/addStudent", consumes="application/json", produces="application/json")
    public Student addStudent(@RequestBody Student student){
        return studentService.addStudent(student);
    }

    @PutMapping(path="/updateStudent", consumes="application/json", produces="application/json")
    public Student updateStudent(@RequestBody Student student, @RequestParam int studentId){
        return studentService.updateStudent(studentId, student);
    }

    @DeleteMapping(path="/delete/{studentId}")
    public String deleteStudent(@PathVariable int studentId){
        return studentService.deleteStudent(studentId);
    }
}

