package com.ssau.study.dto;

import com.ssau.study.entity.Student;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class StudentPojo {
    private long id;
    private String name;
    private Date birthdate;
    private int number;
    private Long groupId;

    public static StudentPojo fromEntity(Student student) {
        StudentPojo studentPojo = new StudentPojo();
        studentPojo.setId(student.getId());
        studentPojo.setName(student.getName());
        studentPojo.setBirthdate(student.getBirthdate());
        studentPojo.setNumber(student.getNumber());
        if (student.getGroup() != null) {
            studentPojo.setGroupId(student.getGroup().getId());
        }
        return studentPojo;
    }

    public static Student toEntity(StudentPojo studentPojo) {
        Student student = new Student();
        student.setId(studentPojo.getId());
        student.setName(studentPojo.getName());
        student.setNumber(studentPojo.getNumber());
        student.setBirthdate(studentPojo.getBirthdate());
        return student;
    }
}
