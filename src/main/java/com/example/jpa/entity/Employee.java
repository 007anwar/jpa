package com.example.jpa.entity;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Entity
@Table(name = "Employee")
public class Employee {
 //   @TableGenerator(name = "employee_gen",table = "id_gen",pkColumnName = "gen_name",valueColumnName = "gen_val",allocationSize = 5)
    @Id
   // @GeneratedValue(strategy = GenerationType.TABLE,generator = "employee_gen")//to use identity as generation type database should this column should be marked with auto incremented
    @GenericGenerator(name = "emp_id",strategy = "com.example.jpa.generator.CustomGenerator")
    @GeneratedValue(generator = "emp_id")
    private Long id;
    private String name;

    public Employee() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
