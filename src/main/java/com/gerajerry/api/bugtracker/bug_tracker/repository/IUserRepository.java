package com.gerajerry.api.bugtracker.bug_tracker.repository;
import com.gerajerry.api.bugtracker.bug_tracker.models.entity.User;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.data.domain.Pageable;

import java.util.Optional;


public interface IUserRepository extends JpaRepository<User, Integer> {
   Page<User> findAll(Pageable pageable);
   Optional<User> findByUsername(String username);
}
