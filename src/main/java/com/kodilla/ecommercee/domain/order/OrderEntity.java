package com.kodilla.ecommercee.domain.order;

import com.kodilla.ecommercee.domain.cart.CartEntity;
import com.kodilla.ecommercee.domain.user.UserEntity;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Date;



@Entity
@Table(name = "ORDERS")
public class OrderEntity {

    private Long id;
    private String adress;
    private Boolean isPaid;
    private Date created;
    private UserEntity user;
    private CartEntity cart;


    public OrderEntity() {
    }

    public OrderEntity(String adress) {
        this.adress = adress;
        this.isPaid = false;
        this.created = new Date();
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @NotNull
    @Column(name = "ID", unique = true)
    public Long getId() {
        return id;
    }

    @NotNull
    @Column(name = "ADRESS")
    public String getAdress() {
        return adress;
    }

    @NotNull
    @Column(name = "PAYMENT_STATUS")
    public Boolean getPaid() {
        return isPaid;
    }

    @NotNull
    @Column(name = "DATE_CREATED")
    public Date getCreated() {
        return created;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setAdress(String adress) {
        this.adress = adress;
    }

    public void setPaid(Boolean paid) {
        isPaid = paid;
    }

    public void setCreated(Date created) {
        this.created = created;
    }

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "CART_ID")
    public CartEntity getCart() {
        return cart;
    }

    public void setCart(CartEntity cart) {
        this.cart = cart;
    }

    @ManyToOne(cascade = {
            CascadeType.PERSIST,
            CascadeType.MERGE,
            CascadeType.REFRESH
    })
    @JoinColumn(name = "USER_ID")
    public UserEntity getUser() {
        return user;
    }

    public void setUser(UserEntity user) {
        this.user = user;
    }

}
