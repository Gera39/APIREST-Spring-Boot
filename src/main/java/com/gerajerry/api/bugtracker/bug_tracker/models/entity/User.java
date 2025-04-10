package com.gerajerry.api.bugtracker.bug_tracker.models.entity;

import com.gerajerry.api.bugtracker.bug_tracker.utils.UserRole;
import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.*;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;


@Entity
@Data
@Table(name = "users")
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class User implements UserDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotNull
    @Size(min = 3, max = 20)
    private String username;
    @NotNull
    @Size(min = 3, max = 20)
    private String name;
    @Column(unique = true)
    @Email
    @NotNull
    private String email;
    private String password;
    @NotNull
    @Enumerated(EnumType.STRING)
    private UserRole role = UserRole.CLIENT;
    @OneToMany(mappedBy = "user",cascade = CascadeType.ALL)
    private Set<UserMembership> userMemberships = new HashSet<>();


    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of(new SimpleGrantedAuthority(role.name()));
    }


    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
