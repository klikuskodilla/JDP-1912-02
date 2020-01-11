package com.kodilla.ecommercee.controller;

import com.kodilla.ecommercee.controller.exceptions.GroupNotFoundException;
import com.kodilla.ecommercee.domain.groups.GroupDto;
import com.kodilla.ecommercee.mapper.GroupMapper;
import com.kodilla.ecommercee.service.DbGroup;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/")
public class GroupController {

    @Autowired
    private GroupMapper groupMapper;

    @Autowired
    private DbGroup dbGroup;

    @RequestMapping(method = RequestMethod.GET, value = "getGroups")
    public List<GroupDto> getGroups() {
        return groupMapper.mapToGroupDtoList(dbGroup.getGroups());
    }

    @RequestMapping(method = RequestMethod.GET, value = "{groupId}")
    public GroupDto getGroupWithId(@PathVariable Long groupId) throws GroupNotFoundException {
        return groupMapper.mapToGroupDto(dbGroup.getGroupById(groupId).orElseThrow(GroupNotFoundException::new));
    }

    @RequestMapping(method = RequestMethod.POST, value = "createGroup", consumes = MediaType.APPLICATION_JSON_VALUE)
    public void createGroup(@RequestBody GroupDto groupDto) {
        dbGroup.saveGroup(groupMapper.mapToGroup(groupDto));
    }

    @RequestMapping(method = RequestMethod.PUT, value = "updateGroup")
    public GroupDto updateGroup(@RequestBody GroupDto groupDto) {
        return groupMapper.mapToGroupDto(dbGroup.saveGroup(groupMapper.mapToGroup(groupDto)));
    }

}
