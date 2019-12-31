package com.kodilla.ecommercee.domain.cart;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.util.List;

@Entity(name = "CARTS")
public class CartEntity {
    private Long id;
    private BigDecimal cost;
/*    private List<ProductEntity> products;
    private UserEntity user;*/

    public CartEntity() {
    }

    @Id
    @NotNull
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "CARTS_ID", unique = true)
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Column(name = "CARDS_PRICE")
    public BigDecimal getCost() {
        return cost;
    }

    public void setCost(BigDecimal cost) {
        this.cost = cost;
    }

/*    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(
            name = "CARDS_PRODUCTS",
            joinColumns = @JoinColumn(name = "CARDS_ID", referencedColumnName = "CARTS_ID"),
            inverseJoinColumns = @JoinColumn(name = "PRODUCT_ID", referencedColumnName = "PRODUCT_ID")
    )
    public List<ProductEntity> getProducts() {
        return products;
    }

    public void setProducts(List<ProductEntity> products) {
        this.products = products;
    }

    @OneToOne(mappedBy = "cart")
    public UserEntity getUser() {
        return user;
    }

    public void setUser(UserEntity user) {
        this.user = user;
    }*/
}
