package com.example.student_management_system.services;

import com.example.student_management_system.model.Student;

import java.util.List;

public interface StudentService {
    Student createStudent(Student student);
    List<Student> getAllStudent();
    Student getSingleStudent(long id);
    Student updateStudentDetails(Student student);
    void deleteStudent(long id);
}
