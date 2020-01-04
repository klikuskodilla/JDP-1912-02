package com.kodilla.ecommercee.domain.groups;

import com.kodilla.ecommercee.domain.Product.Product;
//import lombok.AllArgsConstructor;
//import lombok.Getter;
//import lombok.NoArgsConstructor;
//import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
//import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;


@Entity
@Table(name = "GROUP_PRODUCT")
public class Group {
    private int id;
    private Long groupId;
    private String groupName;
    private List<Product> groupList = new ArrayList<>();

    public Group(){}

    public Group(Long groupId,String groupName) {
        this.groupId = groupId;
        this.groupName = groupName;
    }

    @Id
    @GeneratedValue
    @NotNull
    @Column(name = "ID",unique = true)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @OneToMany(
            targetEntity = Product.class,
            mappedBy = "group",
            cascade = CascadeType.ALL,
            fetch = FetchType.LAZY
    )
    @Column(name = "GROUP_ID")
    public Long getGroupId() {
        return groupId;
    }

    public void setGroupId(Long groupId) {
        this.groupId = groupId;
    }

    @Column(name = "GROUP_NAME")
    public String getGroupName() {
        return groupName;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }

    public List<Product> getGroupList() {
        return groupList;
    }

    private void setGroupList(List<Product> groupList) {
        this.groupList = groupList;
    }

    /*
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
    private List<Product> groupList = new ArrayList<>();


 */
}
