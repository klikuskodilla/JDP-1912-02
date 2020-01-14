package com.kodilla.ecommercee.domain.groups;

//import com.kodilla.ecommercee.domain.Product.Product;

import com.kodilla.ecommercee.domain.Product.Product;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity(name = "GROUP_PRODUCT")
public class Group {

    @Id
    @NotNull
    @GeneratedValue
    @Column(name = "GROUP_ID", unique = true)
    private Long groupId;

    @NotNull
    @Column(name = "GROUP_NAME")
    private String groupName;

    @OneToMany(
            targetEntity = Product.class,
            mappedBy = "group",
            cascade = CascadeType.ALL,
            fetch = FetchType.LAZY
    )
    private List<Product> products;

    public Group(String groupName) {
        this.groupName = groupName;
        this.products = new ArrayList<>();
    }


}
