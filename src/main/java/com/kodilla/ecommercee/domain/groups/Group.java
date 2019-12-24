package com.kodilla.ecommercee.domain.groups;

<<<<<<< HEAD
import com.kodilla.ecommercee.domain.Product.Product;
=======
import com.kodilla.ecommercee.domain.products.ProductEntity;
>>>>>>> origin/JDP191202-13
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "GROUP")
public class Group {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "GROUP_ID", unique = true, nullable = false)
    private Long groupId;

    @Column(name = "GROUP_NAME")
    private String groupName;

    @OneToMany(
<<<<<<< HEAD
            targetEntity = Product.class,
=======
            targetEntity = ProductEntity.class,
>>>>>>> origin/JDP191202-13
            mappedBy = "GROUP",
            cascade = CascadeType.ALL,
            fetch = FetchType.LAZY
    )
<<<<<<< HEAD
    private List<Product> productsGroup = new ArrayList<>();

    public Group(String groupName, List<Product> productsGroup) {
=======
    private List<ProductEntity> productsGroup = new ArrayList<>();

    public Group(String groupName, List<ProductEntity> productsGroup) {
>>>>>>> origin/JDP191202-13
        this.groupName = groupName;
        this.productsGroup = productsGroup;
    }
}
