
package com.example.myApplication.service;

import com.example.myApplication.model.Student;
import com.example.myApplication.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class StudentService implements IStudentService {

    @Autowired
    private StudentRepository studentRepository;

    @Override
    public List<Student> retrieveAllStudents() {
        return studentRepository.findAll();
    }

    @Override
    public Optional<Student> retrieveStudent(int studentId) {
        return studentRepository.findById(studentId);
    }

    @Override
    public Student addStudent(Student newStudent) {
        return studentRepository.save(newStudent);
    }

    @Override
    public Student updateStudent(int studentId,Student student) {

        student.setId(studentId);
        studentRepository.save(student);
        return student;
    }

    @Override
    public String deleteStudent(int studentId) {
        Student studentToDelete = studentRepository.getOne(studentId);
        String msg;
        if(!studentToDelete.equals(null)) {
            studentRepository.delete(studentToDelete);
            msg="Student deleted Successfull with id:"+ studentId;
        } else {
            msg="No Student found with id:"+ studentId + ".Hence student couldn't delete";
        }
        return msg;
    }
}

