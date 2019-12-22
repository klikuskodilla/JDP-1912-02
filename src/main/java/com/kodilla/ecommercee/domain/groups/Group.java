package com.kodilla.ecommercee.domain.groups;

import com.kodilla.ecommercee.domain.products.ProductEntity;
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
            targetEntity = ProductEntity.class,
            mappedBy = "GROUP",
            cascade = CascadeType.ALL,
            fetch = FetchType.LAZY
    )
    private List<ProductEntity> productsGroup = new ArrayList<>();

    public Group(String groupName, List<ProductEntity> productsGroup) {
        this.groupName = groupName;
        this.productsGroup = productsGroup;
    }
}
