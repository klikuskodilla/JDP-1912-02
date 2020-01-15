package com.kodilla.ecommercee.controller.group.controller;

import com.kodilla.ecommercee.domain.Product.ProductDto;
import com.kodilla.ecommercee.domain.groups.GroupDto;
import org.springframework.web.bind.annotation.*;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/v1/group/")
public class GroupController {


    @RequestMapping(method = RequestMethod.GET, value = "getGroups")
    public List<GroupDto> getGroups() {
        List<GroupDto>groupDtos = new ArrayList<>();
        groupDtos.add(new GroupDto(2L,"group name 2", new ProductDto(2L, "description 2", new BigDecimal(2.1))));
        return groupDtos;
    }

    @RequestMapping(method = RequestMethod.GET, value = "{groupId}")
    public GroupDto getGroupWithId(@PathVariable Long groupId){
        return new GroupDto(1L,"group name 1", new ProductDto(1L, "description 1", new BigDecimal(1.22)));
    }

    @RequestMapping(method = RequestMethod.POST, value = "createGroup")
    public GroupDto createGroup(GroupDto groupDto) {
        return new GroupDto(3L,"group name 3", new ProductDto(3L, "description 3", new BigDecimal(3.22)));
    }
}
