package com.example.practic.service;

import com.example.practic.model.Role;

import java.util.List;

public interface RoleService {
    void save(Role role);
    void deleteById(long id);
    List<Role> getRoles();
    Role getRoleByName(String name);
}
