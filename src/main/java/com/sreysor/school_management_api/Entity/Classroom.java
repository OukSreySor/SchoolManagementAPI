package com.sreysor.school_management_api.Entity;


import jakarta.persistence.*;
import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "classrooms")
public class Classroom {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "class")
    private String className;  

    @ManyToOne
    @JoinColumn(name = "create_by_id")
    private User createBy;

    @ManyToOne
    @JoinColumn(name = "update_by_id")
    private User updateBy;

    @ManyToOne
    @JoinColumn(name = "status_by_id")
    private User statusBy;  

}

