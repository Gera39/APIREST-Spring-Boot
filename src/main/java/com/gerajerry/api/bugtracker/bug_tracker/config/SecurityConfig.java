package com.gerajerry.api.bugtracker.bug_tracker.config;

import com.gerajerry.api.bugtracker.bug_tracker.jwt.JwtAuthtenticationFilter;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
public class SecurityConfig {
    private final JwtAuthtenticationFilter jwtAuthtenticationFilter;
    private final AuthenticationProvider authProvider;

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception {
        return httpSecurity
                .csrf(cr ->
                    cr.disable()
                )
                .authorizeHttpRequests( authReques ->
                    authReques
                            .requestMatchers("/auth/**").permitAll()
                            .anyRequest().authenticated()
                )
                .sessionManagement(sessionManager -> {
                    sessionManager.sessionCreationPolicy(SessionCreationPolicy.STATELESS);
                })
                .authenticationProvider(authProvider)
                .addFilterBefore(jwtAuthtenticationFilter, UsernamePasswordAuthenticationFilter.class)
                    .build();
    }
}
