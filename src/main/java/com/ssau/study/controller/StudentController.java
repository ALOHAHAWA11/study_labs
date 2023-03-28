package com.ssau.study.controller;

import com.ssau.study.dto.StudentPojo;
import com.ssau.study.entity.Student;
import com.ssau.study.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/students")
public class StudentController {

    private final StudentService studentService;

    @Autowired
    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping
    public List<StudentPojo> getStudents() {
        return studentService.getStudents();
    }

    @PostMapping()
    public StudentPojo saveStudent(@RequestBody StudentPojo student) {
        return studentService.saveStudent(student);
    }

    @GetMapping(path = "/{id}")
    public Optional<StudentPojo> getStudent(@PathVariable long id) {
        return studentService.getStudent(id);
    }

    @PutMapping
    public StudentPojo updateStudent(@RequestBody StudentPojo studentPojo) {
        return studentService.updateStudent(studentPojo);
    }

    @DeleteMapping(path = "/{id}")
    public long deleteStudent(@PathVariable long id) {
        return studentService.deleteStudent(id);

    }
}
