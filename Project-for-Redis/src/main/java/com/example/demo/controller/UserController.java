package com.example.demo.controller;

import com.example.demo.dao.UserDao;
import com.example.demo.model.User;
import org.springframework.web.bind.annotation.*;

import java.util.Map;
import java.util.UUID;

@RestController
@RequestMapping("/users")
public class UserController {

    private UserDao userDao;

    public UserController(UserDao userDao) {
        this.userDao = userDao;
    }

    @PostMapping
    public User createUser(@RequestBody User user) {
        user.setUserId(UUID.randomUUID().toString());
        return userDao.save(user);
    }

    @GetMapping("/{userId}")
    public User getUser(@PathVariable("userId") String userId) {
        return userDao.get(userId);
    }

    @GetMapping
    public Map<Object, Object> findAll() {
        return userDao.findAll();
    }

    @DeleteMapping("/delete/{userId}")
    public void deleteUser(@PathVariable String userId) {
        userDao.delete(userId);
    }

    @PutMapping("/update/{userId}")
    public User updateUser(@PathVariable String userId) {
        return userDao.update(userId);
    }
}
