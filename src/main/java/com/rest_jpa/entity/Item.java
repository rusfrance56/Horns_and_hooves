package com.rest_jpa.entity;

import com.rest_jpa.entity.to.ItemTO;
import com.rest_jpa.enumTypes.Department;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "items")
@Data
@NoArgsConstructor
public class Item extends BaseEntity {

    @ElementCollection(fetch = FetchType.EAGER)
    @CollectionTable(name = "item_images", joinColumns = @JoinColumn(name = "item_id"))
    @Column(name = "name")
    private List<String> imageNames = new ArrayList<>();

    @Column(name = "department")
    @Enumerated(EnumType.STRING)
    private Department department;

    @Column(name = "price")
    private Double price;

    public Item(ItemTO to) {
        super(to.getName(), to.getDescription());
        this.imageNames = to.getImageNames();
        this.department = to.getDepartment();
        this.price = to.getPrice();
    }

    public static Item updateEntityFromTO(Item entity, ItemTO to) {
        entity.setName(to.getName());
        entity.setDescription(to.getDescription());
        entity.setImageNames(to.getImageNames());
        entity.setDepartment(to.getDepartment());
        entity.setPrice(to.getPrice());
        return entity;
    }
}
