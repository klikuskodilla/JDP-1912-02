package com.kodilla.ecommercee.domain.groups;

//import com.kodilla.ecommercee.domain.Product.Product;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity(name = "GROUP_PRODUCT")
public class Group {

    @Id
    @NotNull
    @Column(name = "GROUP_ID")
    private Long groupId;

    @NotNull
    @Column(name = "GROUP_NAME")
    private String groupName;

/*
    @OneToMany(
            targetEntity = Product.class,
            mappedBy = "GROUP",
            cascade = CascadeType.ALL,
            fetch = FetchType.LAZY
    )

    private List<Product> productsGroup = new ArrayList<>();

    public Group(String groupName, List<Product> productsGroup) {
        this.groupName = groupName;
        this.productsGroup = productsGroup;
    }

     */
}
