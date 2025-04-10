package com.gerajerry.api.bugtracker.bug_tracker.controllers;

import com.gerajerry.api.bugtracker.bug_tracker.models.dto.CreatedMembershipResponse;
import com.gerajerry.api.bugtracker.bug_tracker.models.dto.MembershipResponse;
import com.gerajerry.api.bugtracker.bug_tracker.service.IMembershipService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/v1/memberships")
public class MembershipController {
    private final IMembershipService membershipService;
    /**
     * MembershipController is a REST controller that handles HTTP requests related to memberships.
     * It provides endpoints for retrieving, creating, updating, and deleting memberships.
     */
    @GetMapping
    public ResponseEntity<Map<String,Object>> getAllMemberships(){
        List<MembershipResponse> memberships = membershipService.getAllMemberships();
        Map<String ,Object> response = new HashMap<>();
        response.put("status", true);
        response.put("message", "Memberships retrieved successfully");
        response.put("memberships", memberships);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @GetMapping("/{id}")
    public MembershipResponse findById(@PathVariable Integer id){
        return membershipService.findByIdMembership(id);
    }

    @PostMapping
    public MembershipResponse saveMembership(@RequestBody CreatedMembershipResponse createdMembershipResponse){
        return membershipService.saveMembership(createdMembershipResponse);
    }

    @PutMapping("/{id}")
    public MembershipResponse updateMembership(@PathVariable Integer id, @RequestBody CreatedMembershipResponse createdMembershipResponse){
        return membershipService.update(id, createdMembershipResponse);
    }

    @DeleteMapping("/{id}")
    public void deleteMembership(@PathVariable Integer id){
        membershipService.deleteMembership(id);
    }

    @GetMapping("/addMembership/{idUser}/{idMembership}")
    public ResponseEntity<Map<String,Object>> addMembershipToUser(@PathVariable Integer idUser, @PathVariable Integer idMembership){
        MembershipResponse membershipResponse = membershipService.addMembershipToUser(idUser, idMembership);
        Map<String , Object> response = Map.of(
                "status", true,
                "message", "Membership added to user successfully",
                "membership", membershipResponse
        );

        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

}
