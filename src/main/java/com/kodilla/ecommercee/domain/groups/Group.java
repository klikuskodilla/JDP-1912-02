package com.kodilla.ecommercee.domain.groups;

//import com.kodilla.ecommercee.domain.Product.Product;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "GROUP_PRODUCT")
public class Group {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "GROUP_ID", unique = true, nullable = false)
    private Long groupId;

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
