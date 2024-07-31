package com.example.coffeeweb.Service;

import com.example.coffeeweb.Entity.User;
import com.example.coffeeweb.Pojo.UserPojo;

import java.util.List;

public interface UserService {

    Integer
    saveUser(UserPojo userPojo);

    List<User> findAll();

    User findById(Integer id);

    void deleteById(Integer id);
}
