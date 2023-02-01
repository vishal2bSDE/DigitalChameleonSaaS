package com.example.digitalchameleonsaas.service;

import java.util.List;
import java.util.Optional;
import com.example.digitalchameleonsaas.dao.Address;
import com.example.digitalchameleonsaas.dao.City;
import com.example.digitalchameleonsaas.dao.User;
import com.example.digitalchameleonsaas.repository.UserRepository;
import javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private AddressService addressService;

    @Transactional
    public User getUser(Long id) throws NotFoundException {
        Optional<User> user = userRepository.findById(id);
        if(user.isEmpty())
            throw new NotFoundException("user with {id} not found");

        return user.get();
    }

    @Transactional
    public List<User> getAllUser() throws NotFoundException {
        List<User> user = userRepository.findAll();
        if(user.isEmpty())
            throw new NotFoundException("user with {id} not found");

        return user;
    }

    @Transactional
    public User addUser(String userName, String userAddress) throws NotFoundException {
        Address address = addressService.getAddressByName(userAddress);
        User user = new User();
        user.setName(userName);
        user.setAddress(address);

        return userRepository.save(user);
    }
}
