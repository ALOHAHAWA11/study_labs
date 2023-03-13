package com.ssau.study.service;

import com.ssau.study.dto.StudentPojo;
import com.ssau.study.entity.Student;
import com.ssau.study.repository.GroupRepository;
import com.ssau.study.repository.StudentRepository;
import com.ssau.study.service.interface_service.IStudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentService implements IStudentService {

    private final StudentRepository studentRepository;
    private final GroupRepository groupRepository;

    @Autowired
    public StudentService(StudentRepository studentRepository, GroupRepository groupRepository) {
        this.studentRepository = studentRepository;
        this.groupRepository = groupRepository;
    }

    @Override
    public List<Student> getStudents() {
        return studentRepository.findAll();
    }

    @Override
    public StudentPojo saveStudent(StudentPojo studentPojo) {
        Student student = StudentPojo.toEntity(studentPojo);
        student.setGroup(groupRepository.findById(studentPojo.getGroupId()).orElseThrow());
        student = studentRepository.save(student);
        return StudentPojo.fromEntity(student);
    }

    @Override
    public Optional<StudentPojo> getStudent(long id) {
        if (!studentRepository.existsById(id)) {
            throw new IllegalArgumentException("There is no student with id = " + id);
        } else return studentRepository.findById(id).map(StudentPojo::fromEntity);
    }

    @Override
    public StudentPojo updateStudent(StudentPojo studentPojo) {
        if (!studentRepository.existsById(studentPojo.getId())) {
            throw new IllegalArgumentException("There is no student with id = " + studentPojo.getId());
        } else {
            Student modifying = studentRepository.findById(studentPojo.getId()).get();
            modifying.setName(studentPojo.getName());
            modifying.setBirthdate(studentPojo.getBirthdate());
            modifying.setNumber(studentPojo.getNumber());
            modifying.setGroup(groupRepository.findById(studentPojo.getGroupId()).orElseThrow());
            return StudentPojo.fromEntity(studentRepository.save(modifying));
        }
    }
    @Override
    public long deleteStudent(long id) {
        if (!studentRepository.existsById(id)) {
            throw new IllegalArgumentException("There is no student with id = " + id);
        }
        else {
            studentRepository.deleteById(id);
            return id;
        }
    }
}
