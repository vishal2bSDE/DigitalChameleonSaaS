package com.example.digitalchameleonsaas.dao;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Company extends BaseEntity {

    @ManyToMany(mappedBy = "companies")
    private Set<Address> addresses;

    @OneToMany(mappedBy = "company", cascade = CascadeType.ALL)
    private Set<Job> jobs;

    public Set<Job> getJobs() {
        return jobs;
    }

    public void setJobs(Set<Job> jobs) {
        this.jobs = jobs;
    }

    public Set<Address> getAddresses() {
        return addresses;
    }

    public void setAddresses(Set<Address> addresses) {
        this.addresses = addresses;
    }

    public void addAdress(Address address){
        addresses.add(address);
    }

    public void addJob(Job job){
        if(jobs == null)
            jobs = new HashSet();
        jobs.add(job);
    }
}
