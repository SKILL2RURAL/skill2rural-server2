package com.example.skill2ruralserver.services;


import com.example.skill2ruralserver.dtos.LoginUserDto;
import com.example.skill2ruralserver.repositories.UserRepository;
import com.example.skill2ruralserver.response.AuthenticationResponse;
import com.example.skill2ruralserver.security.JwtService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthenticationService {

    private final UserRepository userRepository;
    private final JwtService jwtService;
    private AuthenticationManager authenticationManager;

    public AuthenticationResponse login(LoginUserDto request) {
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        request.getEmail(),
                        request.getPassword()
                )
        );
        var user = userRepository.findByEmail(request.getEmail()).orElseThrow();

        var jwtToken = jwtService.generateToken(user);
        return AuthenticationResponse.builder().token(jwtToken).build();
    }

}
