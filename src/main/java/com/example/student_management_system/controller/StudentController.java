package com.example.student_management_system.controller;

import com.example.student_management_system.model.Student;
import com.example.student_management_system.repositories.StudentRepository;
import com.example.student_management_system.services.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("*")
@RestController()
@RequestMapping("/api/student")
public class StudentController {

    @Autowired
    private StudentService studentService;

    @Autowired
    private StudentRepository studentRepository;


    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @PostMapping()
    public ResponseEntity<Student> createStudent( @RequestBody Student student){
        return new ResponseEntity<>(studentService.createStudent(student), HttpStatus.CREATED) ;
    }

    @GetMapping()
    public List<Student> getAllStudent(){
        return studentService.getAllStudent();
    }

    @GetMapping("{id}")
    public ResponseEntity<Student> getSingleStudent(@PathVariable("id") long id){
        return new ResponseEntity<>(studentService.getSingleStudent(id), HttpStatus.OK) ;
    }

    @PutMapping()
    public Student updateEmployeeDetails(@RequestBody Student student){
        return  studentRepository.save(student);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteStudent(@PathVariable("id") long studentId){
        studentService.deleteStudent(studentId);
        return new ResponseEntity<>("Employee deleted successfully", HttpStatus.OK);
    }

}
