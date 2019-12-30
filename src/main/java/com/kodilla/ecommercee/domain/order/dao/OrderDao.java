package com.kodilla.ecommercee.domain.order.dao;

import com.kodilla.ecommercee.domain.order.OrderEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Transactional
@Repository
public interface OrderDao extends CrudRepository<OrderEntity, Long> {
}
