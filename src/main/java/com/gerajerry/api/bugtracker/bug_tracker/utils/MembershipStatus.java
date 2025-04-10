package com.gerajerry.api.bugtracker.bug_tracker.utils;

import lombok.Getter;

@Getter
public enum MembershipStatus {
    ACTIVE("Active"),
    INACTIVE("Inactive"),
    EXPIRED("Expired");

    private final String status;

    MembershipStatus(String status){
        this.status = status;
    }

}
