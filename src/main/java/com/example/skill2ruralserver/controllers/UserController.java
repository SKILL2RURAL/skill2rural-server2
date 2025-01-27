package com.example.skill2ruralserver.controllers;


import com.example.skill2ruralserver.dtos.RegisterUserDto;
import com.example.skill2ruralserver.response.AuthenticationResponse;
import com.example.skill2ruralserver.services.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @PostMapping("/")
    public ResponseEntity<AuthenticationResponse> registerUser(
            @RequestBody RegisterUserDto request
    ){
        return ResponseEntity.ok(userService.register(request));
    }

}
