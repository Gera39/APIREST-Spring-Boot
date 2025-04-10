package com.gerajerry.api.bugtracker.bug_tracker.service;

import com.gerajerry.api.bugtracker.bug_tracker.models.dto.AuthRespose;
import com.gerajerry.api.bugtracker.bug_tracker.models.dto.CreatedUserResponse;
import com.gerajerry.api.bugtracker.bug_tracker.models.dto.LoginRequest;
import com.gerajerry.api.bugtracker.bug_tracker.models.entity.User;
import com.gerajerry.api.bugtracker.bug_tracker.repository.IUserRepository;
import com.gerajerry.api.bugtracker.bug_tracker.utils.UserRole;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthService {

    private final IUserRepository userRepository;
    private final JwtService jwtService;
    private final PasswordEncoder passwordEncoder;
    private final AuthenticationManager authenticationManager;

    public AuthRespose login(LoginRequest request){
        authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(request.getUsername(),request.getPassword()));
        UserDetails user = userRepository.findByUsername(request.getUsername())
                .orElseThrow(() -> new RuntimeException("User not found"));
        String token = jwtService.getToken(user);
        return AuthRespose.builder()
                .token(token)
                .build();
    }

    public AuthRespose register(CreatedUserResponse request) {
        User user = User.builder()
                .name(request.getName())
                .username(request.getUsername())
                .password(request.getPassword())
                .email(request.getEmail())
                .role(UserRole.CLIENT)
                .build();
        userRepository.save(user);
        return AuthRespose.builder()
                .token(jwtService.getToken(user))
                .build();
    }

}
