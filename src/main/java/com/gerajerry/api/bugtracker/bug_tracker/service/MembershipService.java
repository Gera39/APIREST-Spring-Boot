package com.gerajerry.api.bugtracker.bug_tracker.service;

import com.gerajerry.api.bugtracker.bug_tracker.mapper.MembershipMapper;
import com.gerajerry.api.bugtracker.bug_tracker.mapper.UserMapper;
import com.gerajerry.api.bugtracker.bug_tracker.models.dto.CreatedMembershipResponse;
import com.gerajerry.api.bugtracker.bug_tracker.models.dto.MembershipResponse;
import com.gerajerry.api.bugtracker.bug_tracker.models.dto.UserResponse;
import com.gerajerry.api.bugtracker.bug_tracker.models.entity.Membership;
import com.gerajerry.api.bugtracker.bug_tracker.models.entity.User;
import com.gerajerry.api.bugtracker.bug_tracker.models.entity.UserMembership;
import com.gerajerry.api.bugtracker.bug_tracker.repository.IMembershipRepository;
import com.gerajerry.api.bugtracker.bug_tracker.repository.IUserMembershipRepository;
import com.gerajerry.api.bugtracker.bug_tracker.repository.IUserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class MembershipService implements  IMembershipService{
    private final MembershipMapper membershipMapper;
    private final IUserRepository userRepository;
    private final IUserMembershipRepository userMembershipRepository;
    private final IMembershipRepository membershipRepository;

    @Override
    public List<MembershipResponse> getAllMemberships() {
        return membershipRepository.findAll()
                .stream()
                .map(membershipMapper::toMembershipResponse)
                .collect(Collectors.toList());
    }

    @Override
    public MembershipResponse findByIdMembership(Integer id) {
        return membershipRepository.findById(id)
                .map(membershipMapper::toMembershipResponse)
                .orElseThrow(() -> new RuntimeException("Membership not found"));
    }

  @Override
  public MembershipResponse saveMembership(CreatedMembershipResponse membership) {
      var newMembership = membershipMapper.toMembershipEntity(membership);
      var savedMembership = membershipRepository.save(newMembership);
      return membershipMapper.toMembershipResponse(savedMembership);
  }
    @Override
    public void deleteMembership(Integer id) {
        Membership membership = membershipRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Membership not found"));
        membershipRepository.delete(membership);
    }

    @Override
    public MembershipResponse update(Integer id, CreatedMembershipResponse membership) {
        return membershipRepository.findById(id)
                .map(membershipe -> {
                    membershipe.setName(membership.getName());
                    membershipe.setDescription(membership.getDescription());
                    membershipe.setPrice(membership.getPrice());
                    return membershipMapper.toMembershipResponse(membershipRepository.save(membershipe));
                })
                .orElseThrow(() -> new RuntimeException("Membership not found"));
    }

    @Override
    public MembershipResponse addMembershipToUser(Integer idUser, Integer idMembership) {
        User user = userRepository.findById(idUser)
                .orElseThrow(() -> new RuntimeException("User not found"));
        Membership membership = membershipRepository.findById(idMembership).orElseThrow(() -> new RuntimeException("Membership not found"));
        UserMembership  newMembership = new UserMembership();
        newMembership.setUser(user);
        newMembership.setMembership(membership);
        newMembership.setStartDate(LocalDateTime.now());
        newMembership.setEndDate(LocalDateTime.now().plusDays(1));
        UserMembership savedMembership = userMembershipRepository.save(newMembership);

        return membershipMapper.toMembershipResponse(savedMembership.getMembership());
    }
}
