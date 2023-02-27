package com.example.practic.service;
import com.example.practic.model.User;

import java.util.List;

public interface UserService {
        List<User> findAll();
        User findById(long id);
        User findUserByUsername(String username);
        User findUserByEmail(String email);
        void insert(User user);
        void deleteById(long id);
        void save(User user);
    }

