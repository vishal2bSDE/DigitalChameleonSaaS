package com.example.digitalchameleonsaas.service;

import java.util.*;
import com.example.digitalchameleonsaas.dao.Address;
import com.example.digitalchameleonsaas.dao.Company;
import com.example.digitalchameleonsaas.dao.Job;
import com.example.digitalchameleonsaas.dao.User;
import com.example.digitalchameleonsaas.repository.CompanyRepository;
import javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class CompanyService {

    @Autowired
    CompanyRepository companyRepository;
    @Autowired
    AddressService addressService;

    @Transactional
    public Company addCompany(String companyName, String addressName) throws NotFoundException {
        Company company = getCompanyOrGetNew(companyName).get();
        Address address = addressService.getAddressByName(addressName);
        Set<Address> addressList = new HashSet<>();
        if(company.getAddresses()==null)
             company.setAddresses(addressList);
        company.addAdress(address);
        address.addCompany(company);

        return companyRepository.save(company);
    }

    private Optional<Company> getCompanyOrGetNew(String companyName) {
        Optional<Company> company = companyRepository.findByName(companyName);
        return company.isEmpty() ? Optional.of(new Company()) : company;
    }

    @Transactional
    public Company getCompanyByName(String companyName) throws NotFoundException {
        Optional<Company> company = companyRepository.findByName(companyName);
        if(company.isEmpty())
            throw new NotFoundException("Company {} not found");

        return company.get();
    }

    @Transactional
    public List<Company> getAllCompanies(){
        return companyRepository.findAll();
    }

    @Transactional
    public List<Company> getAllCompanyByAddress(User user){
        return companyRepository.findAllAddress(user.getAddress());
    }
}
