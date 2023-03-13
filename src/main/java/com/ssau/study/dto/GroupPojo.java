package com.ssau.study.dto;

import com.ssau.study.entity.Group;
import com.ssau.study.entity.Student;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class GroupPojo {
    private long id;
    private String name;
    private List<StudentPojo> students;

    public static GroupPojo fromEntity(Group group) {
        GroupPojo groupPojo = new GroupPojo();
        groupPojo.setId(group.getId());
        groupPojo.setName(group.getName());
        List<StudentPojo> students = new ArrayList<>();
        for (Student student : group.getStudents()){
            students.add(StudentPojo.fromEntity(student));
        }
        groupPojo.setStudents(students);
        return groupPojo;
    }

    public static Group toEntity(GroupPojo groupPojo) {
        Group group = new Group();
        group.setId(groupPojo.getId());
        group.setName(groupPojo.getName());
        List<Student> students = new ArrayList<>();
        for (StudentPojo studentPojo : groupPojo.getStudents()) {
            students.add(StudentPojo.toEntity(studentPojo));
        }
        group.setStudents(students);
        return group;
    }
}
