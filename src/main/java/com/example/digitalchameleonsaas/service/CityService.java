package com.example.digitalchameleonsaas.service;

import java.util.Optional;
import java.util.Set;
import com.example.digitalchameleonsaas.dao.City;
import com.example.digitalchameleonsaas.dao.Country;
import com.example.digitalchameleonsaas.exception.DuplicateRowException;
import com.example.digitalchameleonsaas.repository.CityRepository;
import javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class CityService {
    @Autowired
    private CityRepository cityRepository;
    @Autowired
    private CountryService countryService;

    @Transactional
    public City getCityByName(String name) throws NotFoundException {
        Optional<Set<City>> city = cityRepository.findByName(name);
        if(city.isEmpty())
            throw new NotFoundException("city with {id} not found");
        if(city.get().size()>1)
            throw new DuplicateRowException("Multiple city with {name} found");

        return city.get().stream().iterator().next();
    }

    @Transactional
    public City addCity(String cityName, String countryName) throws NotFoundException {
        Country country = countryService.getCountryByName(countryName);
        City city = new City();
        city.setCountry(country);

        return cityRepository.save(city);
    }
}
