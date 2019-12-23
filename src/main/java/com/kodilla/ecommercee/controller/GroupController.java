package com.kodilla.ecommercee.controller;

import com.kodilla.ecommercee.domain.groups.GroupDto;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("/v1/")
public class GroupController {

   public List<GroupDto> getGroups() {
        return new ArrayList<>();
    }

    public void createGroup(GroupDto groupDto) {
    }
    public GroupDto getGroup(Long groupId) {
        return new GroupDto(1L,"nazwa grupy","grupa produktow");
    }

    public GroupDto updateGroup(GroupDto groupDto) {
        return new GroupDto(1L,"nowa grupa","nowe produkty");
    }
}
