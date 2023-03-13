package com.ssau.study.controller;

import com.ssau.study.dto.GroupPojo;
import com.ssau.study.entity.Group;
import com.ssau.study.entity.Student;
import com.ssau.study.service.GroupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/groups")
public class GroupController {
    @Autowired
    private final GroupService groupService;

    public GroupController(GroupService groupService) {
        this.groupService = groupService;
    }

    @GetMapping
    public List<Group> getGroups() {
        return groupService.getGroups();
    }

    @PostMapping
    public GroupPojo saveGroup(@RequestBody GroupPojo group) {
        return groupService.saveGroup(group);
    }

    @GetMapping(path = "/{id}")
    public Optional<GroupPojo> getGroup(@PathVariable long id) {
        return groupService.getGroup(id);
    }

    @PutMapping
    public GroupPojo updateGroup(@RequestBody GroupPojo groupPojo) {
        return groupService.updateGroup(groupPojo);
    }

    @DeleteMapping(path = "/{id}")
    public long deleteGroup(@PathVariable long id) {
        return groupService.deleteGroup(id);
    }



}
