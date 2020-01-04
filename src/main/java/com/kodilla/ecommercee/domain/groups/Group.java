package com.kodilla.ecommercee.domain.groups;

import com.kodilla.ecommercee.domain.Product.Product;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "GROUP_PRODUCT")
public class Group {

    @Id
    @NotNull
    @Column(name = "GROUP_ID")
    private Long group_id;

    @NotNull
    @Column(name = "GROUP_NAME")
    private String groupName;

    @OneToMany(
            targetEntity = Product.class,
            mappedBy = "group",
            cascade = CascadeType.ALL,
            fetch = FetchType.LAZY
    )
    private List<Product> groupList ;

}
