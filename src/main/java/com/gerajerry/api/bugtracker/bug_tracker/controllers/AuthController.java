package com.gerajerry.api.bugtracker.bug_tracker.controllers;


import com.gerajerry.api.bugtracker.bug_tracker.models.dto.AuthRespose;
import com.gerajerry.api.bugtracker.bug_tracker.models.dto.CreatedUserResponse;
import com.gerajerry.api.bugtracker.bug_tracker.models.dto.LoginRequest;
import com.gerajerry.api.bugtracker.bug_tracker.service.AuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthController {
    private final AuthService authService;
    @PostMapping("/login")
    public ResponseEntity<AuthRespose> login(@RequestBody LoginRequest request){
        return ResponseEntity.ok(authService.login(request));
    }

    @PostMapping("/register")
    public ResponseEntity<AuthRespose> register(@RequestBody CreatedUserResponse request){
        return ResponseEntity.ok(authService.register(request));
    }

}
