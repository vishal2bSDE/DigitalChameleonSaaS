package com.example.digitalchameleonsaas.service;

import java.util.Optional;
import java.util.Set;
import com.example.digitalchameleonsaas.dao.Country;
import com.example.digitalchameleonsaas.exception.DuplicateRowException;
import com.example.digitalchameleonsaas.repository.CountryRepository;
import javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class CountryService {

    @Autowired
    CountryRepository countryRepository;

    @Transactional
    public Country addCountry(String name) throws NotFoundException {
        Country country = new Country();
        country.setName(name);

        return countryRepository.save(country);
    }

    @Transactional
    public Country getCountryByName(String name) throws NotFoundException {
        Optional<Set<Country>> country = countryRepository.findByName(name);
        if(country.isEmpty())
            throw new NotFoundException("address with {name} not found");
        if(country.get().size()>1)
            throw new DuplicateRowException("Multiple address with {name} found");

        return country.get().stream().iterator().next();
    }
}
