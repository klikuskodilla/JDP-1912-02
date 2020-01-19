package com.kodilla.ecommercee.domain.user;

import com.kodilla.ecommercee.domain.cart.CartEntity;
import com.kodilla.ecommercee.domain.order.OrderEntity;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


@Entity
@Table(name = "USERS")
public class UserEntity {

    private Long id;
    private String name;
    private String surname;
    private String login;
    private String mail;
    private String password;
    private Integer sessionKey;
    private Boolean isLoggedIn;
    private Boolean isBlocked;
    private Date sessionKeyValidTo;
    private CartEntity cart;
    private List<OrderEntity> orders = new ArrayList<>();

    public UserEntity() {
    }

    public UserEntity(String name, String surname, String login, String mail, String password) {
        this.name = name;
        this.surname = surname;
        this.login = login;
        this.mail = mail;
        this.password = password;
        this.isLoggedIn = false;
        this.isBlocked = false;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @NotNull
    @Column(name = "ID", unique = true)
    public Long getId() {
        return id;
    }

    @NotNull
    @Column(name = "FIRST_NAME")
    public String getName() {
        return name;
    }

    @NotNull
    @Column(name = "LAST_NAME")
    public String getSurname() {
        return surname;
    }

    @NotNull
    @Column(name = "LOGIN", unique = true)
    public String getLogin() {
        return login;
    }

    @NotNull
    @Column(name = "MAIL", unique = true)
    public String getMail() {
        return mail;
    }

    @NotNull
    @Column(name = "PASSWORD")
    public String getPassword() {
        return password;
    }

    @Column(name = "SESSION_KEY")
    public Integer getSessionKey() {
        return sessionKey;
    }

    @Column(name = "LOGIN_STATUS")
    public Boolean getIsLoggedIn() {
        return isLoggedIn;
    }

    @Column(name = "IS_BLOCKED")
    public Boolean getBlocked() {
        return isBlocked;
    }

    @Column(name = "SESSION_KEY_CREATED_ON")
    public Date getSessionKeyValidTo() {
        return sessionKeyValidTo;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setSessionKey(Integer sessionKey) {
        this.sessionKey = sessionKey;
    }

    public void setIsLoggedIn(Boolean isLoggedIn) {
        this.isLoggedIn = isLoggedIn;
    }

    public void setBlocked(Boolean blocked) {
        isBlocked = blocked;
    }

    public void setSessionKeyValidTo(Date sessionKeyValidTo) {
        this.sessionKeyValidTo = sessionKeyValidTo;
    }

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "USER_CART_ID")
    public CartEntity getCart() {
        return cart;
    }

    public void setCart(CartEntity cart) {
        this.cart = cart;
    }

    @OneToMany(
            targetEntity = OrderEntity.class,
            mappedBy = "user",
            cascade = CascadeType.ALL,
            fetch = FetchType.EAGER
    )
    public List<OrderEntity> getOrders() {
        return orders;
    }

    public void setOrders(List<OrderEntity> orders) {
        this.orders = orders;
    }

}
