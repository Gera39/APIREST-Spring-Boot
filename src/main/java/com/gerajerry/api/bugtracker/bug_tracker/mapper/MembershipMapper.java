package com.gerajerry.api.bugtracker.bug_tracker.mapper;

import com.gerajerry.api.bugtracker.bug_tracker.models.dto.CreatedMembershipResponse;
import com.gerajerry.api.bugtracker.bug_tracker.models.dto.MembershipResponse;
import com.gerajerry.api.bugtracker.bug_tracker.models.entity.Membership;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface MembershipMapper {
    MembershipResponse toMembershipResponse(Membership membership);
    Membership toMembershipEntity(CreatedMembershipResponse membershipResponse);
}
