package com.kodilla.ecommercee.domain.Product;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "PRODUCT")
public class Product{

    @Id
    @GeneratedValue
    @NotNull
    @Column(name = "PRODUCT_ID", unique=true)
    private Long id;

    @Column(name = "DESCRIPTION")
    private String description;

    @NotNull
    @Column(name = "PRICE")
    private BigDecimal price;

 /*   @ManyToOne
    @JoinColumn(name="GROUP_ID")
    @Column(name = "GROUP")
    private Group group;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(
            name = "JOIN_PRODUCTS_CARTS",
            joinColumns = {@JoinColumn (name = "PRODUCT_ID", referencedColumnName = "PRODUCT_ID")},
            inverseJoinColumns = {@JoinColumn (name = "CART_ID", referencedColumnName = "CART_ID")}
            )
    List<CartEntity> carts;
*/

}