package com.sreysor.school_management_api.Entity;

import jakarta.persistence.*;
import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "lecturers")
public class Lecturer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String firstName;

    private String lastName;

    // Each Lecturer teaches one Subject
    @ManyToOne
    @JoinColumn(name = "subject_id")
    private Subject subject;

    @ManyToOne
    @JoinColumn(name = "create_by_id")
    private User createBy;

    @ManyToOne
    @JoinColumn(name = "update_by_id")
    private User updateBy;

    private String status;
}
