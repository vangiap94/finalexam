package com.vti.entity;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "department")
@Getter
@Setter
public class Department {
    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name ="name", length = 50, nullable = false, unique = true)
    private String name;
    @Column(name = "total_members", nullable = false)
    private int totalMembers;

    @Column(name = "type",nullable = false, length = 25)
    @Enumerated(value = EnumType.STRING)
    private Type type;
    @Column(name = "created_at", nullable = false, updatable = false)
    @CreationTimestamp
    private LocalDateTime createdAt;
    @Column(name = "updated_at", nullable = false)
    @UpdateTimestamp
    private LocalDateTime updatedAt;

        @OneToMany(cascade = CascadeType.ALL,mappedBy = "department")
        private List<Account> accounts;


        public enum Type{
        DEVELOPER, TESTER, SCRUM_MASTER, PROJECT_MANAGER
    }
}
