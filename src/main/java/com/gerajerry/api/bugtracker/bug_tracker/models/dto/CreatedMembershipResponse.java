package com.gerajerry.api.bugtracker.bug_tracker.models.dto;

import lombok.*;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class CreatedMembershipResponse {
    private String name;
    private String description;
    private Double price;
}
