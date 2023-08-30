package com.allianz.healthtourism.utils.security;

import com.allianz.healthtourism.database.entity.RoleEntity;
import com.allianz.healthtourism.database.entity.UserEntity;
import com.allianz.healthtourism.database.repository.UserEntityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class SecurityService implements UserDetailsService {


    @Autowired
    UserEntityRepository userEntityRepository;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        Optional<UserEntity> user = userEntityRepository.findByEmail(email);

        if (user.isEmpty()) {
            throw new UsernameNotFoundException("Could not findUser with email =" + email);
        }

        List<SimpleGrantedAuthority> simpleGrantedAuthorityList = new ArrayList<>();
        for (RoleEntity role : userEntityRepository.findUserWithRolesByEmail(email).getRoles()) {
            simpleGrantedAuthorityList.add(new SimpleGrantedAuthority("ROLE_" +  role.getName()));
        }

        return new User(
                email,
                user.get().getPassword(),
                simpleGrantedAuthorityList);
    }


}
