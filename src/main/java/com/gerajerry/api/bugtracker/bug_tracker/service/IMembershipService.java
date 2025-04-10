package com.gerajerry.api.bugtracker.bug_tracker.service;

import com.gerajerry.api.bugtracker.bug_tracker.models.dto.CreatedMembershipResponse;
import com.gerajerry.api.bugtracker.bug_tracker.models.dto.MembershipResponse;

import java.util.List;

public interface IMembershipService {
    List<MembershipResponse> getAllMemberships();
    MembershipResponse findByIdMembership(Integer id);
    MembershipResponse saveMembership(CreatedMembershipResponse membership);
    void deleteMembership(Integer id);
    MembershipResponse update(Integer id, CreatedMembershipResponse membership);
    MembershipResponse addMembershipToUser(Integer idUser, Integer idMembership);
}
