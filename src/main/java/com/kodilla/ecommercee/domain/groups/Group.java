package com.kodilla.ecommercee.domain.groups;

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
@Entity
@Table(name = "GROUP_PRODUCT")
public class Group {

    public Group(String groupName) {
        this.groupName = groupName;
        this.products = new ArrayList<>();
    }




    @Id
    @GeneratedValue()
    @NotNull
    @Column(name = "group_id")
    private Long group_id;

    @Column(name = "group_name")
    @NotNull
    private String groupName;

    @OneToMany(
            targetEntity = Product.class,
            cascade = CascadeType.ALL,
            mappedBy = "group",
            fetch = FetchType.LAZY
    )
    private List<Product> products = new ArrayList<>();

}
