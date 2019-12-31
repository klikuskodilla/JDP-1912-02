package com.kodilla.ecommercee.domain.cart.dao;


import com.kodilla.ecommercee.domain.cart.CartEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@Repository
public interface CartEntityDao extends CrudRepository<CartEntity, Long> {
}
