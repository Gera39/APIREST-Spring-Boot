package com.gerajerry.api.bugtracker.bug_tracker.repository;

import com.gerajerry.api.bugtracker.bug_tracker.models.entity.UserMembership;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IUserMembershipRepository extends JpaRepository<UserMembership,Integer> {
}
