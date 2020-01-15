package com.kodilla.ecommercee.controller.group.controller;

import com.kodilla.ecommercee.domain.Product.ProductDto;
import com.kodilla.ecommercee.domain.groups.Group;
import com.kodilla.ecommercee.domain.groups.GroupDto;
import org.springframework.web.bind.annotation.*;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@RestController
@RequestMapping("/v1/group/")
public class GroupController {

    @RequestMapping(method = RequestMethod.GET, value = "getGroups")
    public List<GroupDto> getGroups() {
        List<ProductDto>productDtos = new ArrayList<>();
        productDtos.add(new ProductDto(2L,"description 2",new BigDecimal(2.2)));
        productDtos.add(new ProductDto(2L,"description 3",new BigDecimal(3.2)));
        List<GroupDto> groupDtos = new ArrayList<>();
        groupDtos.add(new GroupDto(2L,"group name 2",productDtos));
        return groupDtos;
    }

    @RequestMapping(method = RequestMethod.GET, value = "{groupId}")
    public GroupDto getGroupWithId(@PathVariable Long groupId){
        return new GroupDto(1L,"group 1", Collections.singletonList(new ProductDto(1L, "product 1", new BigDecimal(1.1))));

    }

    @RequestMapping(method = RequestMethod.POST, value = "createGroup")
    public void createGroup( GroupDto groupDto) {}
}
