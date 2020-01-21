package com.kodilla.ecommercee.controller.group.mapper;

import com.kodilla.ecommercee.controller.product.ProductMapper;
import com.kodilla.ecommercee.domain.Product.Product;
import com.kodilla.ecommercee.domain.Product.ProductDto;
import com.kodilla.ecommercee.domain.groups.Group;
import com.kodilla.ecommercee.domain.groups.GroupDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class GroupMapper {

    public Group mapToGroup(final GroupDto groupDto) {
        return new Group(
                groupDto.getGroup_id(),
                groupDto.getGroupName());
    }

    public GroupDto mapToGroupDto(final Group group) {
        return new GroupDto(
                group.getGroup_id(),
                group.getGroupName(),group.getProducts());
    }

    public List<GroupDto> mapToGroupDtoList(final List<Group> group) {
        return group.stream()
                .map(g -> new GroupDto(g.getGroup_id(), g.getGroupName(),g.getProducts()))
                .collect(Collectors.toList());
    }
}

