package com.kodilla.ecommercee.domain.Product.dao;

import com.kodilla.ecommercee.domain.Product.Product;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@Repository
public interface ProductDao extends CrudRepository<Product, Long> {
}