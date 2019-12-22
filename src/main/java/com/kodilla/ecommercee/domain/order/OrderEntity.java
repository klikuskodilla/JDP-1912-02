package com.kodilla.ecommercee.domain.order;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;
import java.util.Date;


@NoArgsConstructor
@Getter
@Entity
@Table(name = "ORDERS")
public class OrderEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @NotNull
    @Column(name = "ID", unique = true)
    private Long id;

    @NotNull
    @Column(name = "ADRESS")
    private String adress;

    @NotNull
    @Column(name = "PAYMENT_STATUS")
    private Boolean isPaid;

    @NotNull
    @Column(name = "DATE_CREATED")
    private Date created;

    private UserEntity user;

    private CartEntity cart;

    public OrderEntity(@NotNull String adress, @NotNull Boolean isPaid) {
        this.adress = adress;
        this.isPaid = isPaid;
        this.created = new Date();
    }

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "CART_ID")
    public CartEntity getCart() {
        return cart;
    }

    public void setCart(CartEntity cart) {
        this.cart = cart;
    }

    @ManyToOne
    @JoinColumn(name = "USER_ID")
    public UserEntity getUser() {
        return user;
    }

    public void setUser(UserEntity user) {
        this.user = user;
    }

    public void setPaid(Boolean paid) {
        isPaid = paid;
    }
}
