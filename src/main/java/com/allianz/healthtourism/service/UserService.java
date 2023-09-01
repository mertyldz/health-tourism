package com.allianz.healthtourism.service;

import com.allianz.healthtourism.database.entity.RoleEntity;
import com.allianz.healthtourism.database.entity.UserEntity;
import com.allianz.healthtourism.database.repository.RoleEntityRepository;
import com.allianz.healthtourism.database.repository.UserEntityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
public class UserService {

    @Autowired
    UserEntityRepository userRepository;
    @Autowired
    RoleEntityRepository roleRepository;
    @Autowired
    PasswordEncoder passwordEncoder;


    public void saveUserByRole(UserEntity user) {

        user.setPassword(passwordEncoder.encode(user.getPassword()));
        Set<RoleEntity> roles = new HashSet<>();
        for (RoleEntity role : user.getRoles()) {
            RoleEntity tmpRole = roleRepository.findByName(role.getName()).orElse(null);
            if (tmpRole != null) {
                roles.add(tmpRole);
            }
        }
        user.setRoles(roles);
        userRepository.save(user);
    }

    // Add save methods for user,admin,doctor
    public void saveAdmin(UserEntity user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        Set<RoleEntity> roles = new HashSet<>();
        roles.add(roleRepository.findByName("ADMIN").get());
        user.setRoles(roles);
        userRepository.save(user);
    }

    public void saveUser(UserEntity user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        Set<RoleEntity> roles = new HashSet<>();
        roles.add(roleRepository.findByName("USER").get());
        user.setRoles(roles);
        userRepository.save(user);
    }

    public void saveDoctor(UserEntity user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        Set<RoleEntity> roles = new HashSet<>();
        roles.add(roleRepository.findByName("DOCTOR").get());
        user.setRoles(roles);
        userRepository.save(user);
    }


}
