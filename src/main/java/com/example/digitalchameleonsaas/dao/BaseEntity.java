package com.example.digitalchameleonsaas.dao;

import javax.persistence.*;
import java.util.Set;

@MappedSuperclass
public abstract class BaseEntity {
    private String name;

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private long id;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }
}
