package com.gerajerry.api.bugtracker.bug_tracker.models.dto;

import com.gerajerry.api.bugtracker.bug_tracker.models.entity.Membership;
import com.gerajerry.api.bugtracker.bug_tracker.models.entity.UserMembership;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.Set;

/**
 * UserResponse is a Data Transfer Object (DTO) that represents the response
 * structure for user-related operations in the application.
 * It contains user details such as name, email, role, and memberships.
 *
 **/
@Builder
@Getter
public class UserResponse {
    private Integer id;
    private String name;
    private String email;
    private String role;
    private List<UserMembershipResponse> userMemberships;
}
