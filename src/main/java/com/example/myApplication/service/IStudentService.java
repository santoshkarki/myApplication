package com.example.myApplication.service;

import com.example.myApplication.model.Student;

import java.util.List;
import java.util.Optional;

public interface IStudentService {

    public List<Student> retrieveAllStudents();
    public Optional<Student> retrieveStudent(int studentId);
    public Student addStudent(Student newStudent);
    public Student updateStudent(int studentId,Student student);
    public String deleteStudent(int studentId);
}
