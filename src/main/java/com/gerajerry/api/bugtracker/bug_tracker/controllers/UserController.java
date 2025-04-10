package com.gerajerry.api.bugtracker.bug_tracker.controllers;

import com.gerajerry.api.bugtracker.bug_tracker.models.dto.CreatedUserResponse;
import com.gerajerry.api.bugtracker.bug_tracker.models.dto.UserResponse;
import com.gerajerry.api.bugtracker.bug_tracker.service.IUserService;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("api/v1/users")
public class UserController {
    private final IUserService userService;

    @GetMapping("/pag")
    public ResponseEntity<Page<UserResponse>> getAllUsersPagination(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size){
        return ResponseEntity.ok(userService.getAllUsersPageable(page, size));
    }
    @GetMapping
    public List<UserResponse> findAll(){
        return userService.getAllUsers();
    }

    @GetMapping("/{id}")
    public UserResponse findById(@PathVariable Integer id){
        return userService.findByIdUser(id);
    }

    @PostMapping
    public UserResponse saveUser(@RequestBody CreatedUserResponse createdUserResponse){
        return userService.saveUser(createdUserResponse);
    }

    @PutMapping("/{id}")
    public UserResponse updateUser(@PathVariable Integer id, @RequestBody CreatedUserResponse createdUserResponse){
        return userService.update(id, createdUserResponse);
    }

    @DeleteMapping("/{id}")
    public void deleteUser(@PathVariable Integer id){
        userService.deleteUser(id);
    }
}
