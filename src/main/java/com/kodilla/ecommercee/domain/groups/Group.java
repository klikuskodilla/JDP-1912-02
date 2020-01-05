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

@Entity
@Table(name = "GROUP_PRODUCT")
public class Group {

    private Long group_id;
    private String groupName;
    private List<Product> productsGroup;

    public Group(String groupName) {
        this.groupName = groupName;
        this.productsGroup = new ArrayList<>();
    }

    public Group() {}

    @Id
    @NotNull
    @GeneratedValue
    @Column(name = "GROUP_ID")
    public Long getGroupId() {
        return group_id;
    }

    public void setGroupId(Long groupId) {
        this.group_id = groupId;
    }

    @NotNull
    @Column(name = "GROUP_NAME")
    public String getGroupName() {
        return groupName;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }

    @OneToMany(
            targetEntity = Product.class,
            mappedBy = "group",
            cascade = CascadeType.ALL,
            fetch = FetchType.LAZY
    )
    public List<Product> getProductsGroup() {
        return productsGroup;
    }

    public void setProductsGroup(List<Product> productsGroup) {
        this.productsGroup = productsGroup;
    }
}
