package com.kodilla.ecommercee.domain.Product;

import com.kodilla.ecommercee.domain.cart.CartEntity;
import com.kodilla.ecommercee.domain.groups.Group;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "PRODUCT")
public class Product{

    private Long id;
    private String description;
    private BigDecimal price;
    private Group group;
    private List<CartEntity> carts;

    public Product() {
    }

    public Product(String description, BigDecimal price) {
        this.description = description;
        this.price = price;
    }


    @Id
    @GeneratedValue
    @NotNull
    @Column(name = "PRODUCT_ID", unique=true)
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Column(name = "DESCRIPTION")
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @NotNull
    @Column(name = "PRICE")
    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    @ManyToOne
    @JoinColumn(name = "GROUP_ID")
    public Group getGroup() {
        return group;
    }

    public void setGroup(Group group) {
        this.group = group;
    }

    @ManyToMany(cascade = {
            CascadeType.PERSIST,
            CascadeType.MERGE,
            CascadeType.REFRESH
             },
            mappedBy = "products")
    public List<CartEntity> getCarts() {
        return carts;
    }

    public void setCarts(List<CartEntity> carts) {
        this.carts = carts;
    }


}
