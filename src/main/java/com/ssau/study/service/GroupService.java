package com.ssau.study.service;

import com.ssau.study.dto.GroupPojo;
import com.ssau.study.dto.StudentPojo;
import com.ssau.study.entity.Group;
import com.ssau.study.entity.Student;
import com.ssau.study.repository.GroupRepository;
import com.ssau.study.service.interface_service.IGroupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class GroupService implements IGroupService {

    private final GroupRepository groupRepository;

    @Autowired
    public GroupService(GroupRepository groupRepository) {
        this.groupRepository = groupRepository;
    }

    @Override
    public List<Group> getGroups() {
        return groupRepository.findAll();
    }

    @Override
    public GroupPojo saveGroup(GroupPojo groupPojo) {
        Group group = GroupPojo.toEntity(groupPojo);
        group = groupRepository.save(group);
        return GroupPojo.fromEntity(group);
    }

    @Override
    public Optional<GroupPojo> getGroup(long id) {
        if (!groupRepository.existsById(id)) {
            throw new IllegalArgumentException("There is no group with id = " + id);
        } else return groupRepository.findById(id).map(GroupPojo::fromEntity);
    }

    @Override
    public GroupPojo updateGroup(GroupPojo groupPojo) {
        if (!groupRepository.existsById(groupPojo.getId())) {
            throw new IllegalArgumentException("There is no student with id = " + groupPojo.getId());
        } else {
            Group modifying = groupRepository.findById(groupPojo.getId()).get();
            modifying.setName(groupPojo.getName());
            List<Student> students = new ArrayList<>();
            for (StudentPojo pojoStudent : groupPojo.getStudents()) {
                students.add(StudentPojo.toEntity(pojoStudent));
            }
            modifying.setStudents(students);
            return GroupPojo.fromEntity(groupRepository.save(modifying));
        }
    }

    @Override
    public long deleteGroup(long id) {
        if (!groupRepository.existsById(id)) {
            throw new IllegalArgumentException("There is no student with id = " + id);
        }
        else {
            groupRepository.deleteById(id);
            return id;
        }
    }
}
