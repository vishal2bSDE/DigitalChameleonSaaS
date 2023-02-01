package com.example.digitalchameleonsaas.service;

import java.util.List;
import java.util.Optional;
import java.util.Set;
import com.example.digitalchameleonsaas.dao.Address;
import com.example.digitalchameleonsaas.dao.City;
import com.example.digitalchameleonsaas.exception.DuplicateRowException;
import com.example.digitalchameleonsaas.repository.AddressRepository;
import javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class AddressService {
    @Autowired
    private AddressRepository addressRepository;
    @Autowired
    private CityService cityService;

    @Transactional
    public Address getAddressByName(String name) throws NotFoundException {
        Optional<Set<Address>> address = addressRepository.findByName(name);
        if(address.isEmpty())
            throw new NotFoundException("address with {name} not found");
        if(address.get().size()>1)
            throw new DuplicateRowException("Multiple address with {name} found");

        return address.get().stream().iterator().next();
    }

    @Transactional
    public Address addAddress(String cityName, String addressName) throws NotFoundException {
        City city = cityService.getCityByName(cityName);
        Address address = new Address();
        address.setStreetName(addressName);
        address.setCity(city);

        return addressRepository.save(address);
    }

    @Transactional
    public List<Address> getAllAddress() throws NotFoundException {
        List<Address> addresses = addressRepository.findAll();
        if(addresses.isEmpty())
            throw new NotFoundException("address with {name} not found");

        return addresses;
    }
}
