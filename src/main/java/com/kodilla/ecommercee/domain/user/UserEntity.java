package com.kodilla.ecommercee.domain.user;

import com.kodilla.ecommercee.domain.user.dao.UserEntityDao;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.math.BigInteger;
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
    //private CartEntity cart;
    // private List<OrderEntity> orders;


    public UserEntity() {
    }

    public UserEntity(String name, String surname, String login, String mail, String password) {
        this.name = name;
        this.surname = surname;
        this.login = login;
        this.mail = mail;
        this.password = password;
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

}
