package com.example.skill2ruralserver.controllers;


import com.example.skill2ruralserver.dtos.RegisterUserDto;
import com.example.skill2ruralserver.response.AuthenticationResponse;
import com.example.skill2ruralserver.services.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @PostMapping("/register")
    public ResponseEntity<AuthenticationResponse> registerUser(
            @RequestBody RegisterUserDto request
    ){
        return ResponseEntity.ok(userService.register(request));
    }

    @GetMapping("/hello")
    public  String sayHello(){
        return "Hello world from skill2rural";
    }

}
