package com.sreysor.school_management_api.Entity;

import jakarta.persistence.*;
import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true, nullable = false)
    private String username;

    @Column(nullable = false)
    private String password;

    // Creator user
    @ManyToOne
    @JoinColumn(name = "create_by_id")
    private User createBy;

    // Updater user
    @ManyToOne
    @JoinColumn(name = "update_by_id")
    private User updateBy;

    private String status; 
    private String role;
}
