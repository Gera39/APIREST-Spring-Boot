package com.gerajerry.api.bugtracker.bug_tracker.utils;

import lombok.Getter;

@Getter
public enum UserRole {
    CLIENT("Client"),
    ADMIN("Admin"),
    COACH("Coach");

    private final String role;
    private UserRole(String role){
        this.role = role;
    }

}
