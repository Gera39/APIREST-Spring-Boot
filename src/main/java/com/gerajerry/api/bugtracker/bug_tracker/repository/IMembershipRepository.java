package com.gerajerry.api.bugtracker.bug_tracker.repository;

import com.gerajerry.api.bugtracker.bug_tracker.models.dto.UserResponse;
import com.gerajerry.api.bugtracker.bug_tracker.models.entity.Membership;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface IMembershipRepository extends JpaRepository<Membership, Integer> {
}
