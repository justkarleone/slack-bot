package ru.BoshkaLab.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ru.BoshkaLab.entities.User;
import ru.BoshkaLab.entities.UserType;
import ru.BoshkaLab.repositories.UserTypeRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("user_type")
public class UserTypeController {
    @Autowired
    private UserTypeRepository userTypeRepository;

    @GetMapping("/get")
    public Iterable<UserType> getAll() {
        return userTypeRepository.findAll();
    }

    @PostMapping("/add")
    public UserType create(@RequestBody Map<String, String> newUserType) {
        if (!newUserType.containsKey("name"))
            return null;
        String name = newUserType.get("name");
        return new UserType(name);
    }
}
