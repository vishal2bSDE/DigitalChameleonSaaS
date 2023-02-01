package com.example.digitalchameleonsaas.dao;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

public class Address extends BaseEntity{

    @ManyToOne
    @JoinColumn(name = "id", nullable = false)
    private City city;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(
            name = "company_address",
            joinColumns = @JoinColumn(name = "address.id"),
            inverseJoinColumns = @JoinColumn(name = "company.id"))
    private Set<Company> companies;

    @OneToMany(mappedBy = "address", cascade = CascadeType.ALL)
    private Set<User> users;

    public Set<User> getUsers() {
        return users;
    }

    public void setUsers(Set<User> users) {
        this.users = users;
    }

    public Set<Company> getCompanies() {
        return companies;
    }

    public void setCompanies(Set<Company> companies) {
        this.companies = companies;
    }

    public void addCompany(Company company){
        if(companies == null)
            companies = new HashSet();
        companies.add(company);
    }

    public City getCity() {
        return city;
    }

    public void setCity(City city) {
        this.city = city;
    }

    public String getStreetName() {
        return getName();
    }

    public void setStreetName(String streetName) {
        setName(streetName);
    }
}
