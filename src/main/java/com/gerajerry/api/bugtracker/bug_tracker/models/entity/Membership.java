package com.gerajerry.api.bugtracker.bug_tracker.models.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;
import java.util.*;

@Entity
@Data
@Table(name= "memberships")
@AllArgsConstructor
@NoArgsConstructor
public class Membership {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @NotNull
    @Size(min=20, max=70)
    @Column(name = "name", unique = true)
    private String name;

    @NotNull
    @Column(columnDefinition = "TEXT")
    private String description;

    @NotNull
    @Column(name = "price")
    private Double price;


}
