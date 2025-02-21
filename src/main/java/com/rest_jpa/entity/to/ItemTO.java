package com.rest_jpa.entity.to;

import com.rest_jpa.entity.Item;
import com.rest_jpa.enumTypes.Department;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ItemTO {
    private long id;
    private String name;
    private String description;
    private List<String> imageNames;
    private Department department;
    private double price;
    private LocalDateTime updated;

    public ItemTO(Item item) {
        this.id = item.getId();
        this.name = item.getName();
        this.description = item.getDescription();
        this.imageNames = item.getImageNames();
        this.department = item.getDepartment();
        this.price = item.getPrice();
        this.updated = item.getUpdated();
    }
}
