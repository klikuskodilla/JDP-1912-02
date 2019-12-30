package com.kodilla.ecommercee.domain.user;

import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.List;

@NoArgsConstructor
@Entity
@Table(name = "USERS")
public class UserEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @NotNull
    @Column(name = "ID", unique = true)
    @Getter
    private Long id;

    @NotNull
    @Column(name = "FIRST_NAME")
    @Getter
    private String name;

    @NotNull
    @Column(name = "LAST_NAME")
    @Getter
    private String surname;

    @NotNull
    @Column(name = "LOGIN", unique = true)
    @Getter
    private String login;

    @NotNull
    @Column(name = "MAIL", unique = true)
    @Getter
    private String mail;

    @NotNull
    @Column(name = "PASSWORD")
    @Getter
    private String password;

    @Column(name = "SESSION_KEY")
    @Getter
    private Integer sessionKey;


    //private CartEntity cart;

    //private List<OrderEntity> orders;

    public UserEntity(@NotNull String name, @NotNull String surname, @NotNull String login, @NotNull String mail, @NotNull String password) {
        this.name = name;
        this.surname = surname;
        this.login = login;
        this.mail = mail;
        this.password = password;
    }

    //@OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    //@JoinColumn(name = "USER_CART_ID")
    //public CartEntity getCart() {
    //    return cart;
    //}

    //public void setCart(CartEntity cart) {
    //    this.cart = cart;
    //}

    //@OneToMany(
    //        targetEntity = OrderEntity.class,
    //        mappedBy = user,
    //        cascade = CascadeType.REFRESH,
    //        fetch = FetchType.EAGER
    //)
    //public List<OrderEntity> getOrders() {
    //    return orders;
    //}

    //public void setOrders(List<OrderEntity> orders) {
    //    this.orders = orders;
    //}

    public void setSessionKey(Integer sessionKey) {
        this.sessionKey = sessionKey;
    }
}
