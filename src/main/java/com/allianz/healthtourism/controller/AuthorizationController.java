package com.allianz.healthtourism.controller;

import com.allianz.healthtourism.database.entity.UserEntity;
import com.allianz.healthtourism.model.requestDTO.LoginRequestDTO;
import com.allianz.healthtourism.service.UserService;
import com.allianz.healthtourism.utils.security.JWTUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("auth")
public class AuthorizationController {
    @Autowired
    UserService userService;
    @Autowired
    private AuthenticationManager authManager;
    @Autowired
    private JWTUtil jwtUtil;

    @PostMapping("login")
    public Map<String, Object> loginHandler(@RequestBody LoginRequestDTO body) {
        UsernamePasswordAuthenticationToken authInputToken =
                new UsernamePasswordAuthenticationToken(body.getEmail(), body.getPassword());

        authManager.authenticate(authInputToken);

        String token = jwtUtil.generateToken(body.getEmail());

        Map<String, Object> authorizationMap = new HashMap<>();
        authorizationMap.put("jwt-token", token);
        //authorizationMap.put("gender", user.getGenderEnum() != null ? user.getGenderEnum().name() : "");
        //Collections.singletonMap("jwt-token", token);

        return authorizationMap;
    }

    @PostMapping("register")
    public ResponseEntity<Boolean> loginHandler(@RequestBody UserEntity body) {

        userService.saveUserByRole(body);

        return new ResponseEntity<>(Boolean.TRUE, HttpStatus.OK);


    }

    @PostMapping("register/admin")
    public ResponseEntity<Boolean> registerAdmin(@RequestBody UserEntity body) {
        userService.saveAdmin(body);
        return new ResponseEntity<>(Boolean.TRUE, HttpStatus.OK);
    }

    @PostMapping("register/doctor")
    public ResponseEntity<Boolean> registerDoctor(@RequestBody UserEntity body) {
        userService.saveDoctor(body);
        return new ResponseEntity<>(Boolean.TRUE, HttpStatus.OK);
    }

    @PostMapping("register/user")
    public ResponseEntity<Boolean> registerUser(@RequestBody UserEntity body) {
        userService.saveUser(body);
        return new ResponseEntity<>(Boolean.TRUE, HttpStatus.OK);
    }


}
