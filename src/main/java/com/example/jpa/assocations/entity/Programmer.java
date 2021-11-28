package com.example.jpa.assocations.entity;

import java.util.Set;

public class Programmer {
    private int id;
    private String name;
    private int salary;
    private Set<Project> projectSet;
}
