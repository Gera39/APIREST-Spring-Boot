package com.gerajerry.api.bugtracker.bug_tracker.models.entity;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Table(name = "users_memberships")
@Getter
@Setter
public class UserMembership {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

   @ManyToOne(fetch = FetchType.LAZY)
   @JoinColumn(name = "user_id", foreignKey = @ForeignKey(name = "FK_user_membership_user"))
   private User user;

   @ManyToOne(fetch = FetchType.LAZY)
   @JoinColumn(name = "membership_id", foreignKey = @ForeignKey(name = "FK_user_membership_membership"))
   private Membership membership;



    private LocalDateTime startDate;
    private LocalDateTime endDate;
    private boolean isActive;
    private int usageCount;


}
