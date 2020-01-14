package com.kodilla.ecommercee.domain.groups.dao;

import com.kodilla.ecommercee.domain.groups.Group;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import javax.swing.text.html.Option;
import java.util.Optional;

@Transactional
@Repository
public interface GroupDao extends CrudRepository<Group, Long> {

    Optional<Group> findByGroupName(String groupName);

