package com.ssau.study.service.interface_service;

import com.ssau.study.dto.GroupPojo;
import com.ssau.study.entity.Group;

import java.util.List;
import java.util.Optional;

public interface IGroupService {
    List<GroupPojo> getGroups();

    GroupPojo saveGroup(GroupPojo groupPojo);

    Optional<GroupPojo> getGroup(long id);

    GroupPojo updateGroup(GroupPojo groupPojo);

    long deleteGroup(long id);


}
