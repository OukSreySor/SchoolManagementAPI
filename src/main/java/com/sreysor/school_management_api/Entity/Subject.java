package com.sreysor.school_management_api.Entity;


import jakarta.persistence.*;
import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "subjects")
public class Subject {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String subject;

    @ManyToOne
    @JoinColumn(name = "create_by_id")
    private User createBy;

    @ManyToOne
    @JoinColumn(name = "update_by_id")
    private User updateBy;

    private String status;
}
