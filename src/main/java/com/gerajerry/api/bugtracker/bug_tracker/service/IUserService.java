package com.gerajerry.api.bugtracker.bug_tracker.service;

import com.gerajerry.api.bugtracker.bug_tracker.models.dto.CreatedUserResponse;
import com.gerajerry.api.bugtracker.bug_tracker.models.dto.UserResponse;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.*;

public interface IUserService {
    Page<UserResponse> getAllUsersPageable(int pag ,int size);
    List<UserResponse> getAllUsers();
    UserResponse findByIdUser(Integer id);
//    List<UserResponse> findAllByMembership(Integer id);
    UserResponse saveUser(CreatedUserResponse user);
    void deleteUser(Integer id);
    UserResponse update(Integer id, CreatedUserResponse user);
}
