package com.vti.entity;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.Formula;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "account")
@Getter
@Setter
public class Account {
    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private int id;
    @Column(name = "username", length = 255, nullable = false, unique = true, updatable = false)
    private String username;

    @Column(name = "password", length = 72, nullable = false)
    private String password;
    @Column(name = "first_name", length = 50, nullable = false)
    private String firstName;
    @Column(name = "last_name", length = 50, nullable = false)
    private String lastName;
    @Formula(value = "concat(first_name,' ', last_name)")
    private String fullName;
    @Column(name = "role", nullable = false, length = 8)
    @Enumerated(value = EnumType.STRING)
    private Role role;
    @Column(name = "created_at", nullable = false, updatable = false)
    @CreationTimestamp
    private LocalDateTime createdAt;


    @ManyToOne
    @JoinColumn(name = "department_id", referencedColumnName = "id")
    private Department department;

    public enum Role {
        ADMIN, MANAGER, EMPLOYEE
    }

}
