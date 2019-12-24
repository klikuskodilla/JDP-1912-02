package com.kodilla.ecommercee.domain.groups.dao;

import com.kodilla.ecommercee.domain.groups.Group;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Transactional
@Repository
public interface GroupDao extends CrudRepository<Group, Integer> {

    List<Group> findByGroupId(Long Id);

}
