package com.example.skill2ruralserver.services;


import com.example.skill2ruralserver.dtos.RegisterUserDto;
import com.example.skill2ruralserver.entities.User;
import com.example.skill2ruralserver.repositories.UserRepository;
import com.example.skill2ruralserver.response.AuthenticationResponse;
import com.example.skill2ruralserver.security.JwtService;
import com.example.skill2ruralserver.utilities.enums.Role;
import lombok.RequiredArgsConstructor;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;


@Service
@RequiredArgsConstructor
public class UserService {

    private final JwtService jwtService;

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public AuthenticationResponse register(RegisterUserDto request) {
        var user = User.builder()
                .name(request.getName())
                .email(request.getEmail())
                .password(passwordEncoder.encode(request.getPassword()))
                .role(Role.STUDENT)
                .build();

        userRepository.save(user);

        var jwtToken = jwtService.generateToken(user);
        return AuthenticationResponse.builder().token(jwtToken).build();

    }
}
