package com.gerajerry.api.bugtracker.bug_tracker.mapper;

import com.gerajerry.api.bugtracker.bug_tracker.models.dto.UserResponse;
import com.gerajerry.api.bugtracker.bug_tracker.models.entity.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;
@Mapper(componentModel = "spring", uses = {UserMembershipMapper.class})
public interface UserMapper {
    @Mapping(target = "userMemberships", source = "userMemberships" )
    UserResponse toUserResponse(User user);
}