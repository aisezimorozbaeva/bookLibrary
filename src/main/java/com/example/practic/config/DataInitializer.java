package com.example.practic.config;

import com.example.practic.model.Role;
import com.example.practic.model.User;
import com.example.practic.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

@Component
@RequiredArgsConstructor
public class DataInitializer {
    private final UserService userService;

    @PostConstruct
    public void initDataBaseFilling() {
        usersAndRolesInit();
    }
        private void usersAndRolesInit() {
            User user = new User();
            user.setUsername("user");
            user.setLastName("userov");
            user.setEmail("user@gmail.com");
            user.setPassword("$2a$12$X9w1iOGDuiI0bIh.juTHue4OfhZH0Md2v5kKaCX2SiuQqPqqkV0Re");
            user.setPhoneNumber("0705250086");

            LocalDate birthDate = LocalDate.of(1989, 6, 1);

            LocalDate registerDate = LocalDate.now();
            user.setRegisterDate(registerDate);

            Role role = new Role();
            role.setName("ROLE_USER");
            Set<Role> roleSet = new HashSet<>();
            roleSet.add(role);

            user.setRoles(roleSet);

            userService.save(user);


            User admin = new User();
            admin.setUsername("admin");
            admin.setLastName("adminov");
            admin.setEmail("admin@gmail.com");
            admin.setPassword("$2a$12$X9w1iOGDuiI0bIh.juTHue4OfhZH0Md2v5kKaCX2SiuQqPqqkV0Re");
            admin.setPhoneNumber("0705250086");
            LocalDate birthDateAdmin = LocalDate.of(1989, 6, 1);

            LocalDate registerDateAdmin = LocalDate.now();
            admin.setRegisterDate(registerDateAdmin);
            Role roleAdmin = new Role();
            roleAdmin.setName("ROLE_ADMIN");
            Set<Role> roles = new HashSet<>();
            roles.add(roleAdmin);
            admin.setRoles(roles);
            userService.save(admin);
        }

}
