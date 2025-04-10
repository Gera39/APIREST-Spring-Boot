package com.gerajerry.api.bugtracker.bug_tracker.models.dto;

import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class UserMembershipResponse {
    private Integer id;
    private Integer membershipId;
    private String membershipName;
    private Double price;
}
