package com.gerajerry.api.bugtracker.bug_tracker.models.dto;

import lombok.*;
import java.util.Set;

/**
 * MembershipResponse is a Data Transfer Object (DTO) that represents the response
 * structure for membership-related operations in the application.
 * It contains membership details such as name, description, price, and associated users.
 *
 */
@Builder
@Getter
public class MembershipResponse {
    private Integer id;
    private String name;
    private String description;
    private Double price;

//    private Set<UserResponse> users;
}
