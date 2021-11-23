package com.example.jpa.entity;

import javax.persistence.*;

@Entity
@Table(name = "paymentj")
@Inheritance(strategy = InheritanceType.JOINED)
public class PaymentPerSubClass {
    @Id
    private Integer id;
    private double amount;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }
}
