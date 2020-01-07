package com.kodilla.ecommercee.domain.cart;

import com.kodilla.ecommercee.domain.Product.Product;
import com.kodilla.ecommercee.domain.user.UserEntity;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Entity(name = "CARTS")
public class CartEntity {
    private Long id;
    private BigDecimal cost;
    private List<Product> products;
    private UserEntity user;

    public CartEntity() {
        this.products = new ArrayList<>();
    }

    @Id
    @NotNull
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "CART_ID", unique = true)
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Column(name = "CART_PRICE")
    public BigDecimal getCost() {
        return cost;
    }

    public void setCost(BigDecimal cost) {
        this.cost = cost;
    }

    @ManyToMany(cascade = {
            CascadeType.PERSIST,
            CascadeType.MERGE,
            CascadeType.REFRESH
    })
    @JoinTable(
            name = "CARTS_PRODUCTS",
            joinColumns = @JoinColumn(name = "CART_ID", referencedColumnName = "CART_ID"),
            inverseJoinColumns = @JoinColumn(name = "PRODUCT_ID", referencedColumnName = "PRODUCT_ID")
    )
    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }

    @OneToOne(mappedBy = "cart")
    public UserEntity getUser() {
        return user;
    }

    public void setUser(UserEntity user) {
        this.user = user;
    }
}
