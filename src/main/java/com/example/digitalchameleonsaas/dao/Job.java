package com.example.digitalchameleonsaas.dao;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Job extends BaseEntity {

    @ManyToOne
    @JoinColumn(name = "id", nullable = false)
    private Company company;

    private int openings;

    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }

    public int getOpenings() {
        return openings;
    }

    public void setOpenings(int openings) {
        this.openings = openings;
    }
}
