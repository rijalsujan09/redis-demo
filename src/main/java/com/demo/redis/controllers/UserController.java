package com.demo.redis.controllers;

import com.demo.redis.dao.UserDao;
import com.demo.redis.models.User;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/users")
public class UserController {

    private final UserDao userDao;

    public UserController(UserDao userDao) {
        this.userDao = userDao;
    }


    @PostMapping
    public User createUser(@RequestBody User user){
        return userDao.saveUser(user);
    }

    @GetMapping("/{userId}")
    public User getUserById(@PathVariable("userId") String userId){
        return userDao.getUser(userId);
    }


    @DeleteMapping("/{userId}")
    public String deleteUser(@PathVariable("userId") String userId){
        userDao.deleteUser(userId);
        return "user deleted successfully";
    }


    @GetMapping("/all")
    public List<User> getAllUser(){
        return userDao.getAll();
    }
}
