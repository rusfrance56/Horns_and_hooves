package com.rest_jpa.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(schema = "public", name = "department")
public class Department extends BaseEntity{

    @JsonIgnore
    @OneToMany(mappedBy = "department", cascade = CascadeType.ALL)
    private List<Employee> employeeList;

    @JsonIgnore
    @OneToMany(mappedBy = "department", cascade = CascadeType.ALL)
    private List<Order> orderList;

    public Department() {
    }

    public Department(Long id, String name) {
        super(id, name);
        this.employeeList = new ArrayList<>();
        this.orderList = new ArrayList<>();
    }

    public List<Employee> getEmployeeList() {
        return employeeList;
    }

    public List<Order> getOrderList() {
        return orderList;
    }
}
