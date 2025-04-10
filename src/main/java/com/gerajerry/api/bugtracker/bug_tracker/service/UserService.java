package com.gerajerry.api.bugtracker.bug_tracker.service;
import com.gerajerry.api.bugtracker.bug_tracker.mapper.UserMapper;
import com.gerajerry.api.bugtracker.bug_tracker.mapper.UserMapper;
import com.gerajerry.api.bugtracker.bug_tracker.models.dto.CreatedUserResponse;
import com.gerajerry.api.bugtracker.bug_tracker.models.dto.UserResponse;
import com.gerajerry.api.bugtracker.bug_tracker.models.entity.User;
import com.gerajerry.api.bugtracker.bug_tracker.repository.IMembershipRepository;
import com.gerajerry.api.bugtracker.bug_tracker.repository.IUserRepository;
import com.gerajerry.api.bugtracker.bug_tracker.utils.UserRole;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class UserService implements IUserService{
    private final IUserRepository userRepository;
    private final IMembershipRepository membershipRepository;
    private final UserMapper userMapper;

    @Override
    public List<UserResponse> getAllUsers() {
        return userRepository.findAll()
                .stream()
                .map(userMapper::toUserResponse)
                .collect(Collectors.toList());
    }
    @Override
    public Page<UserResponse> getAllUsersPageable(int page, int size) {
        return userRepository.findAll(PageRequest.of(page, size))
                .map(userMapper::toUserResponse);
    }
    @Override
    public UserResponse findByIdUser(Integer id) {
       return userRepository.findById(id)
                .map(userMapper::toUserResponse)
                .orElseThrow(() -> new RuntimeException("User not found"));
    }

//    @Override
//    public List<UserResponse> findAllByMembership(Integer id) {
//        return membershipRepository.findById(id)
//                .map(userRepository::findAllByMemberships)
//                .map(users -> users.stream()
//                        .map(userMapper::toUserResponse)
//                        .collect(Collectors.toList()))
//                .orElseThrow(() -> new RuntimeException("Membership not found"));
//    }


    @Override
    public UserResponse saveUser(CreatedUserResponse user) {
        return membershipRepository.findById(user.getId_membership())
                .map(membership -> {
                    User newUser = new User();
                    newUser.setName(user.getName());
                    newUser.setEmail(user.getEmail());
                    newUser.setPassword(user.getPassword());
                    newUser.setRole(Enum.valueOf(UserRole.class, user.getRole()));
//                    newUser.getMemberships().add(membership);
//                    newUser.getUsers().add(newUser);
                    return userRepository.save(newUser);
                }).map(userMapper::toUserResponse)
                .orElseThrow(() -> new RuntimeException("Error Create User"));
    }

    @Override
    public void deleteUser(Integer id) {
        if(userRepository.findById(id).isEmpty()){
            throw new RuntimeException("User not found");
        }
        userRepository.deleteById(id);
    }
    @Override
    public UserResponse update(Integer id, CreatedUserResponse user) {
        return userRepository.findById(id)
                .map(users -> membershipRepository
                        .findById(user.getId_membership())
                        .map(membership -> {
                            users.setName(user.getName());
                            users.setEmail(user.getEmail());
                            users.setPassword(user.getPassword());
                            users.setRole(Enum.valueOf(UserRole.class, user.getRole()));
                            return userRepository.save(users);
                        })
                        .orElseThrow(() -> new RuntimeException("Membership not found"))
                ).map(userMapper::toUserResponse)
                .orElseThrow(() -> new RuntimeException("User not found"));
    }
}
