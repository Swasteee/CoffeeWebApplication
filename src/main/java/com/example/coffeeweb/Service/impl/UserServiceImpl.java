package com.example.coffeeweb.Service.impl;

import com.example.coffeeweb.Entity.User;
import com.example.coffeeweb.Pojo.UserPojo;
import com.example.coffeeweb.Repository.UserRepository;
import com.example.coffeeweb.Service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;

    @Override
    public Integer saveUser(UserPojo userPojo) {
        User user = new User();
        user.setUserName(userPojo.getUserName());
        user.setEmailAddress(userPojo.getEmailAddress());
        user.setPassword(userPojo.getPassword());
        user.setContact(userPojo.getContact());
        userRepository.save(user);
        return user.getUser_id();

    }

    @Override
    public List<User> findAll() {
        return userRepository.findAll();
    }

    @Override
    public User findById(Integer id) {
        return (User) userRepository.findById(id).orElse(null);
    }

    @Override
    public void deleteById(Integer id) {
        userRepository.deleteById(id);
    }
}
