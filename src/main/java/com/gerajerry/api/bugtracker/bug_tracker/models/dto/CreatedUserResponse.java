package com.gerajerry.api.bugtracker.bug_tracker.models.dto;

import lombok.*;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class CreatedUserResponse {
    private String name;
    private String email;
    private String username;
    private String role;
    private String password;
    private Integer id_membership;
}
