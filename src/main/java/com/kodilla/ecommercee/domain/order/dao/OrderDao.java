package com.kodilla.ecommercee.domain.order.dao;

import com.kodilla.ecommercee.domain.order.OrderEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Transactional
@Repository
public interface OrderDao extends CrudRepository<OrderEntity, Long> {

    @Override
    List<OrderEntity> findAll();

}
