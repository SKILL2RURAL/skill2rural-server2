package com.example.skill2ruralserver.controllers;


import com.example.skill2ruralserver.dtos.LoginUserDto;
import com.example.skill2ruralserver.response.AuthenticationResponse;
import com.example.skill2ruralserver.services.AuthenticationService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthenticationController {

    private final AuthenticationService service;

    @PostMapping("/login/student")
    public ResponseEntity<AuthenticationResponse> login(@RequestBody LoginUserDto request){
        return ResponseEntity.ok(service.login(request));
    }
}
