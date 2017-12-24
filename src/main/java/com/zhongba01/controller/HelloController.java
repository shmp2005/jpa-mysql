package com.zhongba01.controller;

import com.zhongba01.domain.User;
import com.zhongba01.domain.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class HelloController {

    @Autowired
    UserRepository userRepository;

    @GetMapping("/add")
    public String addNewUser(@RequestParam String name,
                             @RequestParam String email) {

        User user = new User();
        user.setName(name);
        user.setEmail(email);
        userRepository.save(user);

        return user.toString();
    }


    @GetMapping("/all")
    public Iterable<User> getAllUsers() {
        return userRepository.findAll();
    }

    @GetMapping("/{id}")
    public User getUser(@PathVariable long id){
        return userRepository.findById(id);
    }

    @GetMapping("/byName/{name}")
    public Iterable<User> getUserByName(@PathVariable String name){
        return userRepository.findByName(name);
    }
}
