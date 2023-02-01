package com.example.digitalchameleonsaas.controller;

import java.util.List;
import com.example.digitalchameleonsaas.dao.User;
import com.example.digitalchameleonsaas.service.UserService;
import javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/user")
public class UserController {

    @Autowired
    UserService userService;

    @PostMapping("/addUser")
    public ResponseEntity<User> addUser(@RequestParam("name") String name, @RequestParam("address") String address) throws NotFoundException {
        return ResponseEntity.ok(userService.addUser(name, address));
    }

    @GetMapping("/getUser")
    public ResponseEntity<User> getUser(@RequestParam("userId") Long id) throws NotFoundException {
        return ResponseEntity.ok(userService.getUser(id));
    }

    @GetMapping("/getAllUsers")
    public ResponseEntity<List<User>> getUserAll() throws NotFoundException {
        return ResponseEntity.ok(userService.getAllUser());
    }
}
