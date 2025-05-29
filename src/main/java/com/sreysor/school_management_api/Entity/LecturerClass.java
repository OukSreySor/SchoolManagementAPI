package com.sreysor.school_management_api.Entity;


import jakarta.persistence.*;
import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "lecturer_class")
public class LecturerClass {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "lecturer_id")
    private Lecturer lecturer;

    @ManyToOne
    @JoinColumn(name = "class_id")
    private Classroom classroom;

    @ManyToOne
    @JoinColumn(name = "create_by_id")
    private User createBy;

    @ManyToOne
    @JoinColumn(name = "update_by_id")
    private User updateBy;

    private String status;
}
