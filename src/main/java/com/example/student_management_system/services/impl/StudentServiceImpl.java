package com.example.student_management_system.services.impl;

import com.example.student_management_system.exception.ResourceNotFoundException;
import com.example.student_management_system.model.Student;
import com.example.student_management_system.repositories.StudentRepository;
import com.example.student_management_system.services.StudentService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentServiceImpl implements StudentService {
    private StudentRepository studentRepository;

    public StudentServiceImpl(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    @Override
    public Student createStudent(Student student) {
        return studentRepository.save(student);
    }

    @Override
    public List<Student> getAllStudent() {
        return studentRepository.findAll();
    }

    @Override
    public Student getSingleStudent(long id) {
        return studentRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Student", "Id", id));
    }

    @Override
    public Student updateStudentDetails(Student student) {
        Student existingStudent = studentRepository.save(student);

//        existingStudent.setFirstName(student.getFirstName());
//        existingStudent.setLastName(student.getLastName());
//        existingStudent.setEmail(student.getEmail());
//        studentRepository.save(student);

        return existingStudent;
    }

    @Override
    public void deleteStudent(long id) {
        studentRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Employee", "Id", id));
        studentRepository.deleteById(id);
    }
}
