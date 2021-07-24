package com.guilhermeamorim.security;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

import com.guilhermeamorim.security.model.Role;
import com.guilhermeamorim.security.model.User;
import com.guilhermeamorim.security.repository.RoleRepository;
import com.guilhermeamorim.security.repository.UserRepository;

@Component
public class DataLoader implements CommandLineRunner {

    @Autowired
    UserRepository userRepository;
    @Autowired
    RoleRepository roleRepository;
    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    @Override
    public void run(String... args) throws Exception {
        roleRepository.save(new Role("USER"));
        roleRepository.save(new Role("ADMIN"));

        Role adminRole = roleRepository.findByRole("ADMIN");
        Role userRole = roleRepository.findByRole("USER");

        User user = new User("admin@code.com", passwordEncoder.encode("password"),"Admin", "Super", true, "admin" );
        user.setRoles(Arrays.asList(adminRole));
        userRepository.save(user);

        user = new User("user@code.com", passwordEncoder.encode("password"),"User", "Super", true, "user" );
        user.setRoles(Arrays.asList(userRole));
        userRepository.save(user);

    }
}
