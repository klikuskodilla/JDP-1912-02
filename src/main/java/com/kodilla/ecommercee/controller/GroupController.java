package com.kodilla.ecommercee.controller;

import com.kodilla.ecommercee.domain.Product.Product;
import com.kodilla.ecommercee.domain.Product.ProductDto;
import com.kodilla.ecommercee.domain.groups.GroupDto;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;


@RestController
@RequestMapping("/v1/")
public class GroupController {

    @RequestMapping(method = RequestMethod.GET, value = "getGroups")
    public List<GroupDto> getGroups() {
        return new ArrayList<>();
    }

    @RequestMapping(method = RequestMethod.POST, value = "createGroup", consumes = APPLICATION_JSON_VALUE)
    public void createGroup(@RequestBody GroupDto groupDto) {
    }
    @RequestMapping(method = RequestMethod.GET, value = "{groupId}")
    public GroupDto getGroup(@PathVariable Long groupId) {
        return new GroupDto(1L,"name group", (List<ProductDto>) new Product("kk","elo",new BigDecimal(5.66)));
    }

    @RequestMapping(method = RequestMethod.PUT, value = "updateGroup")
    public GroupDto updateGroup(@RequestBody GroupDto groupDto) {
        return new GroupDto(1L,"update group", (List<ProductDto>) new Product("zmiana 1","zmiana11",new BigDecimal(9.89)));
    }
}
