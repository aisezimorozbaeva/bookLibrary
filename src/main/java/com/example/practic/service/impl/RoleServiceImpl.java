package com.example.practic.service.impl;

import com.example.practic.model.Role;
import com.example.practic.repository.RoleRepository;
import com.example.practic.service.RoleService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class RoleServiceImpl implements RoleService {

    private final RoleRepository roleRepository;

    @Override
    public void save(Role role) {
        roleRepository.save(role);
    }

    @Override
    public void deleteById(long id) {
        roleRepository.deleteById(id);
    }

    @Override
    public List<Role> getRoles() {
        return roleRepository.findAll();
    }

    @Override
    public Role getRoleByName(String name) {
        return getRoles().stream().filter(r ->
                        r.getName().equals(name)).findAny()
                .orElse(null);
    }
}

