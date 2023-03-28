package com.ssau.study.entity;

import com.ssau.study.security.Role;
import com.ssau.study.security.Status;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "students", schema = "public")
@Getter
@Setter
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(unique = true)
    private String username;
    private String password;
    @Enumerated(value = EnumType.STRING)
    private Status status;
    @Enumerated(value = EnumType.STRING)
    private Role role;
}
