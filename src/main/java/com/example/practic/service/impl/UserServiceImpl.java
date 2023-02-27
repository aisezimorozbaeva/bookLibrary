package com.example.practic.service.impl;
import com.example.practic.model.Role;
import com.example.practic.model.User;
import com.example.practic.repository.UserRepository;
import com.example.practic.service.RoleService;
import com.example.practic.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final RoleService roleService;

    @Override
    public List<User> findAll() {
        return userRepository.findAll();
    }

    @Override
    public User findById(long id) {
        Optional<User> user = userRepository.findById(id);
        return user.orElse(null);
    }

    @Override
    public User findUserByUsername(String username) {
        return userRepository.findUserByUsername(username).orElse(null);
    }

    @Override
    public User findUserByEmail(String email) {
        return userRepository.findUserByEmail(email).orElse(null);
    }

    /**
     * Роль юзера назначаеться автоматически всем новым пользователям.
     *
     * @param user
     */
    @Override
    public void insert(User user) {
        String encryptedPass = passwordEncoder.encode(user.getPassword());
        user.setPassword(encryptedPass);
        Set<Role> rolesFromBD = new HashSet<>();
        rolesFromBD.add(roleService.getRoleByName("ROLE_USER"));
        user.setRoles(rolesFromBD);
        user.setRegisterDate(LocalDate.now());
        userRepository.save(user);
    }

    @Override
    public void deleteById(long id) {
        userRepository.deleteById(id);
    }

    @Override
    public void save(User user) {
        userRepository.save(user);
    }
}
