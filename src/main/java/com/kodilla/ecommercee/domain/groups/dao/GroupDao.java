package com.kodilla.ecommercee.domain.groups.dao;

import com.kodilla.ecommercee.domain.groups.Group;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Repository
@Transactional
public interface GroupDao extends CrudRepository<Group, Long> {

    @Override
    List<Group> findAll();

    @Override
    Optional<Group> findById(Long id);

    @Override
    Group save(Group group);

    @Override
    void deleteById(Long id);

    @Override
    long count();

}
