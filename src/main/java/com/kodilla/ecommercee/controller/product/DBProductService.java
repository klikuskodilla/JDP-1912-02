package com.kodilla.ecommercee.controller.product;

import com.kodilla.ecommercee.domain.Product.Product;
import com.kodilla.ecommercee.domain.Product.dao.ProductDao;
import com.kodilla.ecommercee.domain.groups.Group;
import com.kodilla.ecommercee.domain.groups.dao.GroupDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class DBProductService {
    @Autowired
    private ProductDao allProductsRepository;
    @Autowired
    private ProductDao singleProductRepository;
    @Autowired
    private ProductDao saveProductRepository;
    @Autowired
    private ProductDao deletePeoductRepository;
    @Autowired
    private GroupDao setGroupRepository;
    @Autowired
    private GroupDao saveGroupRepository;
    @Autowired

    public List<Product> getAllProducts(){
        return allProductsRepository.findAll();
    }

    public Optional<Product> getProduct(final Long productId){
        return singleProductRepository.findById(productId);
    }

    public Product saveProduct(final Product product){
        if (setGroupRepository.findByGroupName(product.getGroup().getGroupName()).isPresent()){
            product.setGroup(setGroupRepository.findByGroupName(product.getGroup().getGroupName()).get());
            Group group = setGroupRepository.findByGroupName(product.getGroup().getGroupName()).get();
            group.getProducts().add(product);
            saveGroupRepository.save(group);
            return saveProductRepository.findByDescription(product.getDescription()).get();
        } else {
            Group group = new Group(product.getGroup().getGroupName());
            product.setGroup(group);
            group.getProducts().add(product);
            saveGroupRepository.save(group);
            return saveProductRepository.findByDescription(product.getDescription()).get();
        }
    }

    public Product updateProduct(final Product product){
        return saveProductRepository.save(product);
    }


    public void deleteProductById(final Long productId){
        deletePeoductRepository.deleteById(productId);
    }

}
