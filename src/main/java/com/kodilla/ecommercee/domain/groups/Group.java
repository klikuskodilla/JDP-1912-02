package com.kodilla.ecommercee.domain.groups;

import com.kodilla.ecommercee.domain.Product.Product;
import com.kodilla.ecommercee.domain.Product.ProductDto;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;

//@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "GROUP_PRODUCT")
public class Group {

    public Group(String groupName) {
        this.groupName = groupName;
        this.products = new ArrayList<>();
    }
    @Id
    @NotNull
    @GeneratedValue
    @Column(name = "GROUP_ID")
    private Long group_id;

    @Column(name = "GROUP_NAME")
    @NotNull
    private String groupName;
    @OneToMany(
            targetEntity = Product.class,
            cascade = CascadeType.ALL,
            mappedBy = "group",
            fetch = FetchType.LAZY
    )
    private List<Product> products = new ArrayList<>();

    public Group(Long group_id, String groupName) {
    }
}
