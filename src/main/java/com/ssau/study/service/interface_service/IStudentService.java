package com.ssau.study.service.interface_service;

import com.ssau.study.dto.StudentPojo;
import com.ssau.study.entity.Student;

import java.util.List;
import java.util.Optional;

public interface IStudentService {
    List<StudentPojo> getStudents();

    StudentPojo saveStudent(StudentPojo studentPojo);

    Optional<StudentPojo> getStudent(long id);

    StudentPojo updateStudent(StudentPojo studentPojo);

    long deleteStudent(long id);
}
