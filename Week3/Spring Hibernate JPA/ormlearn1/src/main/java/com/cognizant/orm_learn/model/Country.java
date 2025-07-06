package com.cognizant.orm_learn.model;

import jakarta.persistence.*;

@Entity
@Table(name = "country")
public class Country {

    @Id
    @Column(name = "co_code")
    private String code;

    @Column(name = "co_name")
    private String name;

    // Getters and Setters
    // toString() method
    @Override
    public String toString() {
        return "Country{code='" + code + "', name='" + name + "'}";
    }

}
