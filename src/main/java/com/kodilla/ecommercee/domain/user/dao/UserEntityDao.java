package com.kodilla.ecommercee.domain.user.dao;

import com.kodilla.ecommercee.domain.user.UserEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@Repository
public interface UserEntityDao extends CrudRepository<UserEntity, Long> {


}
