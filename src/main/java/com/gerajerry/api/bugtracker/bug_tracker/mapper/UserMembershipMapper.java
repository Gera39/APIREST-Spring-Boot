package com.gerajerry.api.bugtracker.bug_tracker.mapper;

import com.gerajerry.api.bugtracker.bug_tracker.models.dto.UserMembershipResponse;
import com.gerajerry.api.bugtracker.bug_tracker.models.entity.UserMembership;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface UserMembershipMapper {
    @Mapping(target = "membershipId" , source = "membership.id")
    @Mapping(target = "membershipName" , source = "membership.name")
    @Mapping(target = "price" , source = "membership.price")
    @Mapping(target = "id" , source = "userMembership.id")
    UserMembershipResponse toUserMembershipResponse(UserMembership userMembership);
}
